package main

import (
	"fmt"
	_ "github.com/go-sql-driver/mysql"
	"github.com/jmoiron/sqlx"
)

type UserRole struct {
	Id   int    `db:"id"`
	Name string `db:"name"`
}

var Db *sqlx.DB

func init() {
	database, err := sqlx.Open("mysql", "root:123456@tcp(127.0.0.1:3306)/huiyou")
	if err != nil {
		fmt.Println("open mysql failed", err)
		return
	}
	Db = database
	//defer Db.Close()
}

func main() {
	defer Db.Close()
	var roles []UserRole
	Db.Select(&roles, "select id, name from user_role")
	fmt.Println("select succ:", roles)
}
