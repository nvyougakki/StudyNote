package main

import (
	"encoding/json"
	"fmt"
	"log"
)

type Movie struct {
	Name string
	Year int `json:"released"`
	Color bool `json:"color,omitempty"`
	Actors []string
}

func main() {
	var movies = []Movie{
		{Name: "movie1", Year: 1942, Color: true, Actors: []string{"heyi1", "test1"}},
		{Name: "movie2", Year: 1942, Color: false, Actors: []string{"heyi1", "test1"}},
	}
	data, err := json.MarshalIndent(movies, "", "	")

	if err != nil {  
		log.Fatal("JSON marshaling fail: %s", err)
	}
	fmt.Printf("%s\n", data)
}


