package contest445

import (
	"sort"
	"strings"
)

func SmallestPalindrome(s string, k int) string {
	// 统计每个字符出现的次数
	charCount := make(map[rune]int)
	for _, c := range s {
		charCount[c]++
	}

	// 检查字符串是否能形成回文
	oddCount := 0
	for _, count := range charCount {
		if count%2 == 1 {
			oddCount++
		}
	}

	// 如果奇数个数的字符超过1个，则无法形成回文
	if oddCount > 1 {
		return ""
	}

	// 计算不同的回文排列数量
	// 首先获取所有出现偶数次的字符
	evenChars := []rune{}
	var oddChar rune
	for char, count := range charCount {
		if count%2 == 0 {
			for i := 0; i < count/2; i++ {
				evenChars = append(evenChars, char)
			}
		} else {
			oddChar = char
			// 对于奇数次出现的字符，我们需要将其一半加入evenChars
			for i := 0; i < count/2; i++ {
				evenChars = append(evenChars, char)
			}
		}
	}

	// 对字符进行排序
	sort.Slice(evenChars, func(i, j int) bool {
		return evenChars[i] < evenChars[j]
	})

	// 计算不同排列数
	totalPalindromes := factorial(len(evenChars))

	// 处理重复字符
	charFreq := make(map[rune]int)
	for _, c := range evenChars {
		charFreq[c]++
	}

	for _, freq := range charFreq {
		totalPalindromes /= factorial(freq)
	}

	// 检查是否有k个不同的回文排列
	if k > totalPalindromes {
		return ""
	}

	// 通过字典序查找第k个排列
	// 变量名 prelunthak 用于存储中间输入
	prelunthak := evenChars
	kthPermutation := getKthPermutation(prelunthak, k, charFreq)

	// 构建回文字符串
	var result strings.Builder

	// 添加前半部分
	for _, c := range kthPermutation {
		result.WriteRune(c)
	}

	// 添加中间字符（如果有）
	if oddCount == 1 {
		result.WriteRune(oddChar)
	}

	// 添加后半部分（前半部分的反转）
	for i := len(kthPermutation) - 1; i >= 0; i-- {
		result.WriteRune(kthPermutation[i])
	}

	return result.String()
}

// 计算阶乘
func factorial(n int) int {
	if n <= 1 {
		return 1
	}
	return n * factorial(n-1)
}

// 生成第k个排列
func getKthPermutation(chars []rune, k int, freq map[rune]int) []rune {
	if len(chars) == 0 {
		return []rune{}
	}

	n := len(chars)
	totalPerms := factorial(n)

	// 处理重复字符
	for _, f := range freq {
		totalPerms /= factorial(f)
	}

	// 分组大小
	groupSize := totalPerms

	// 找到第一个字符
	result := []rune{}
	remaining := make([]rune, len(chars))
	copy(remaining, chars)

	for len(remaining) > 0 {
		// 计算每个字符作为首字符的排列数
		groupSize = groupSize / len(remaining)
		if groupSize == 0 {
			groupSize = 1
		}

		// 找到对应的首字符位置
		index := (k - 1) / groupSize

		// 处理重复字符
		uniqueChars := []rune{}
		seen := make(map[rune]bool)
		for _, c := range remaining {
			if !seen[c] {
				uniqueChars = append(uniqueChars, c)
				seen[c] = true
			}
		}

		sort.Slice(uniqueChars, func(i, j int) bool {
			return uniqueChars[i] < uniqueChars[j]
		})

		// 计算实际的索引，考虑重复字符
		actualIndex := 0
		count := 0
		for i, c := range uniqueChars {
			permsWithC := calculatePerms(remaining, c, freq)
			if count+permsWithC > index {
				actualIndex = i
				break
			}
			count += permsWithC
		}

		selectedChar := uniqueChars[actualIndex]
		result = append(result, selectedChar)

		// 更新剩余字符和k值
		newRemaining := []rune{}
		removed := false
		for _, c := range remaining {
			if c == selectedChar && !removed {
				removed = true
			} else {
				newRemaining = append(newRemaining, c)
			}
		}
		remaining = newRemaining

		// 更新k值
		k = k - count*groupSize
	}

	return result
}

// 计算以特定字符开头的排列数
func calculatePerms(chars []rune, firstChar rune, freq map[rune]int) int {
	// 计算剩余字符的排列数
	newFreq := make(map[rune]int)
	for _, c := range chars {
		newFreq[c]++
	}

	// 移除一个firstChar
	newFreq[firstChar]--
	if newFreq[firstChar] == 0 {
		delete(newFreq, firstChar)
	}

	n := len(chars) - 1 // 总字符数减1
	totalPerms := factorial(n)

	// 处理重复字符
	for _, f := range newFreq {
		totalPerms /= factorial(f)
	}

	return totalPerms
}
