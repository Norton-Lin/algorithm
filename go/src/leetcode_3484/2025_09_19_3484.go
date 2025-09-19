package main

import (
	"strconv"
	"strings"
)

type Spreadsheet struct {
	sheet [][]int
}

func Constructor(rows int) Spreadsheet {
	sheet := make([][]int, 26)
	for i := 0; i < len(sheet); i++ {
		sheet[i] = make([]int, rows)
	}
	return Spreadsheet{sheet}
}

func (ss *Spreadsheet) SetCell(cell string, value int) {
	row := cell[0] - 'A'
	col, _ := strconv.Atoi(cell[1:])
	ss.sheet[row][col] = value
}

func (ss *Spreadsheet) ResetCell(cell string) {
	row := cell[0] - 'A'
	col, _ := strconv.Atoi(cell[1:])
	ss.sheet[row][col] = 0
}

func (ss *Spreadsheet) GetValue(formula string) int {
	nums := strings.Split(formula[1:], "+")
	num1, num2 := 0, 0
	if cur, err := strconv.Atoi(nums[0]); err != nil {
		row := nums[0][0] - 'A'
		col, _ := strconv.Atoi(nums[0][1:])
		num1 = ss.sheet[row][col]
	} else {
		num1 = cur
	}
	if cur, err := strconv.Atoi(nums[1]); err != nil {
		row := nums[1][0] - 'A'
		col, _ := strconv.Atoi(nums[1][1:])
		num2 = ss.sheet[row][col]
	} else {
		num2 = cur
	}
	return num1 + num2
}
