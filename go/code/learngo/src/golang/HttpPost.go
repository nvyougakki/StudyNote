package main

import (
	"bytes"
	"encoding/base64"
	"fmt"
	"io/ioutil"
	"net/http"
)

func main() {
	fileBytes, _ := ioutil.ReadFile("C:/Users/heyu/Desktop/IMG_4298.JPG")
	encode := base64.StdEncoding.EncodeToString(fileBytes)
	json := "{\"checkItem\": 2004,\n\t\"siteId\": \"5GWZ2001190539_01\",\n\t\"aiResult\": 1,\n\t\"sectorId\": 0,\n\t\"picName\": \"test-ai\",\n\t\"message\": \"test-ai-msg\",\"file\":\""+encode+"\"}"
	resp, _ := http.Post("http://localhost:9001/uav/open/site/check", "application/json", bytes.NewBuffer([]byte(json)))
	body, _ := ioutil.ReadAll(resp.Body)
	fmt.Println(string(body))
	defer resp.Body.Close()
}
