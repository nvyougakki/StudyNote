package main

import (
	"fmt"
	"golang.org/x/net/html"
	"net/http"
)

func main() {
	data, err := findLinks2("http://www.baidu.com")
	if err != nil {
		fmt.Println(err)
	}

	for _, i := range data {
		fmt.Println(i)
	}
}

func findLinks2(url string) ([]string, error) {
	resp, err := http.Get(url)
	if err != nil {
		return nil, err
	}

	if resp.StatusCode != http.StatusOK {
		return nil, fmt.Errorf("getting %s: %s", url, resp.Status)
	}
	//b, _ := ioutil.ReadAll(resp.Body)
	doc, err := html.Parse(resp.Body)

	resp.Body.Close()
	//fmt.Printf("%s", b)
	if err != nil {
		return nil, fmt.Errorf("parsing %s as HTML: %v", url, err)
	}
	return visit(nil, doc), nil
}

func visit(links []string, n *html.Node) []string {

	if n.Type == html.ElementNode && n.Data == "a" {
		for _, a := range n.Attr {
			if a.Key == "href" {
				links = append(links, a.Val)
				//fmt.Println(links)
			}
		}
	}
	//for c := n.FirstChild; c != nil; c = c.NextSibling {
	//	links = visit(links, c)
	//}
	if n.FirstChild != nil {
		links = visit(links, n.FirstChild)
	}
	if n.NextSibling != nil {
		links = visit(links, n.NextSibling)
	}
	return links
}



func outline(stack [] string, n *html.Node) {
	if n.Type == html.ElementNode {
		stack = append(stack, n.Data)
		fmt.Println(stack)
	}

	for c := n.FirstChild; c != nil; c = c.NextSibling {
		outline(stack, c)
	}
}
