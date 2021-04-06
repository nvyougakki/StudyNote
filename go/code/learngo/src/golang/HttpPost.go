package main

import (
	"bytes"
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"
)

type SiteParam struct {
	CheckItem string `json:"checkItem"`
	SiteId    string `json:"siteId"`
	AiResult  int    `json:"aiResult"`
	SectorId  int    `json:"sectorId"`
	PicName   string `json:"picName"`
	Message   string `json:"message"`
	File      string `json:"file"`
}

type AiParam struct {

}

func main() {
	//siteId := "5GHZ1812210312-NRD"
	//
	//encode := base64.StdEncoding.EncodeToString(fileBytes)
	//json := "{\"checkItem\": 2004,\n\t\"siteId\": \"" + siteId + "\",\n\t\"aiResult\": 0,\n\t\"sectorId\": 0,\n\t\"picName\": \"test-ai\",\n\t\"message\": \"test-ai-msg\",\"file\":\"" + encode + "\"}"
	//resp, _ := http.Post("http://121.196.57.43/uav-service/open/site/check", "application/json", bytes.NewBuffer([]byte(json)))
	//defer resp.Body.Close()
	//body, _ := ioutil.ReadAll(resp.Body)
	//fmt.Println(string(body))
	fileBytes, _ := ioutil.ReadFile("C:/Users/heyu/Desktop/IMG_4298.JPG")
	siteParam := SiteParam{
		"2006",
		"C2030463200033-1624254",
		0,
		1,
		"test-pic-name",
		"test-msg",
		string(fileBytes),
	}
	paramsByte, _ := json.Marshal(siteParam)
	fmt.Println(string(paramsByte))
	resp, _ := http.Post("http://192.168.0.146/uav-service/open/site/check", "application/json", bytes.NewBuffer(paramsByte))
	defer resp.Body.Close()
	body, _ := ioutil.ReadAll(resp.Body)
	fmt.Println(string(body))

}

