package main

import (
	"fmt"
	"io/ioutil"
	"net/http"
	"regexp"
)
var (
	reQQEmail = `(\d+)@([0-9a-zA-Z]*?)\.([a-zA-Z]+)`

	rePhone = `(1[3456789]\d).*(\d{4}).*(\d{4})`
)

func GetEmail() {
	//字节转字符串
	pageStr := GetPageStr("https://tieba.baidu.com/p/6051076813?red_tag=1573533731")

	//过滤qq邮箱
	re := regexp.MustCompile(reQQEmail)

	//-1代表读取全部
	results := re.FindAllStringSubmatch(pageStr, -1)

	for _, result := range results {
		fmt.Println("email:", result[0])
		fmt.Println("qq:", result[1])
		fmt.Println("website:", result[2])
	}



}
func GetPageStr(url string) (pageStr string){
	resp, err := http.Get(url)

	HandleError(err, "http.Get url")

	defer resp.Body.Close()
	data, err := ioutil.ReadAll(resp.Body)
	HandleError(err, "ioutil.ReadAll")
	return string(data)
}

func GetPhone() {
	pageStr := GetPageStr("http://www.zhaohaowang.com/")
	//fmt.Println(pageStr)
	re := regexp.MustCompile(rePhone)
	datas := re.FindAllStringSubmatch(pageStr, -1)

	for i, data := range datas{
		fmt.Printf("%d\t%s\t%s\n",i, data[1] + data[2] + data[3], data[0])
	}

}

func HandleError(err error, why string) {
	if err != nil {
		fmt.Println(why, err)
	}
}

func main() {
	//GetEmail()
	GetPhone()
}
