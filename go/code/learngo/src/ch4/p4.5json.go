package main

import (
	"encoding/json"
	"fmt"
	"log"
	"net/http"
	"net/url"
	"os"
	"strings"
	"time"
)

type Movie struct {
	Name string
	Year int `json:"released"`
	Color bool `json:"color,omitempty"`
	Actors []string
}

func main() {
	/*var movies = []Movie{
		{Name: "movie1", Year: 1942, Color: true, Actors: []string{"heyi1", "test1"}},
		{Name: "movie2", Year: 1942, Color: false, Actors: []string{"heyi1", "test1"}},
	}
	data, err := json.MarshalIndent(movies, "", "	")

	if err != nil {
		log.Fatal("JSON marshaling fail: %s", err)
	}
	fmt.Printf("%s\n", data)*/

	result, err := SearchIssues(os.Args[1:])
	if err != nil {
		log.Fatal(err)
	}

	fmt.Printf("%d issues:\n", result.Total)

	for _, item := range result.Items {
		fmt.Printf("#%-5d %9.9s %.55s\n", item.Number, item.User.Login, item.Title)
	}

}

func SearchIssues(terms []string) (*IssuesSearchResult, error) {
	q := url.QueryEscape(strings.Join(terms, " "))
	resp, err := http.Get(IssuesUrl + "?q=" + q)
	if err != nil {
		return nil, err
	}

	if resp.StatusCode != http.StatusOK {
		resp.Body.Close()
		return nil, fmt.Errorf("search query fail:%s", resp.Status)
	}
	var result IssuesSearchResult
	if err := json.NewDecoder(resp.Body).Decode(&result); err != nil {
		resp.Body.Close()
		return nil, err;
	}
	resp.Body.Close()
	return &result, nil


}

const IssuesUrl string = "https://api.github.com/search/issues"

type IssuesSearchResult struct {
	Total int `json:"total_count"`
	Items []Issue
}

type Issue struct {
	Number int
	//Url string
	HTMLURL string `json:"html_url"`
	Title string
	State string
	User *User
	CreatedAt time.Time `json:"created_at"`
	Body string
}

type User struct {
	Login string
	Id int64
	NODEID string `json:"node_id"`
}


