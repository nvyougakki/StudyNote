package main

import (
	"encoding/json"
	"fmt"
	_ "github.com/go-sql-driver/mysql"
	"github.com/jmoiron/sqlx"
	"io/ioutil"
	"net/http"
	"strings"
)

type UserRole struct {
	Id   int    `db:"id"`
	SubnetName string `db:"subnet_name"`
	CompanyName string `db:"company_name"`
}

type BaiduResult struct {
	Results [] struct{
		Name string `json:"name"`
		Location struct{
			Lat float64 `json:"lat"`
			Lng float64 `json:"lng"`
		} `json:"location"`
	} `json:"results"`
}


var Db *sqlx.DB

func init() {
	database, err := sqlx.Open("mysql", "root:Un2wa2e#Z7@tcp(121.196.57.43:3306)/sgcc")
	if err != nil {
		fmt.Println("open mysql failed", err)
		return
	}
	Db = database
	//defer Db.Close()
}

func main() {
	defer Db.Close()
	var datas []UserRole
	Db.Select(&datas, "select id, subnet_name, company_name from device_ip_config where longitude is null or latitude is null")


	//str := "台州-浙江之恩环保产业园有限公司#14"
	//reg := regexp.MustCompile("^.+?-(.*?)[-#]$")
	//result := reg.FindAllStringSubmatch(str, -1)
	//fmt.Println(result)
	//fmt.Println(result[0][1])
	for i := 0; i < len(datas); i++ {
		url := "http://api.map.baidu.com/place/v2/search?query=" + strings.ReplaceAll(strings.Split(strings.Split(datas[i].CompanyName, "-")[1], "#")[0], "浙江", "") +
			"&region=" + string([]rune(datas[i].SubnetName)[1:3]) +
			"&output=json&ak=qi50bY3STQhYsDmISw8yP1EI8UUbppf6"
		fmt.Println(url)
		resp, _ := http.Get(url)
		defer resp.Body.Close()
		bytes, _ := ioutil.ReadAll(resp.Body)
		fmt.Println()
		var result BaiduResult
		json.Unmarshal(bytes, &result)
		if len(result.Results) > 0 {
			location := result.Results[0].Location
			Db.Exec("update device_ip_config set longitude = ?, latitude = ? where id = ?", location.Lng, location.Lat, datas[i].Id)
		}

	}

	//fmt.Println("select succ:", datas)
}
