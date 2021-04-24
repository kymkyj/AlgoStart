이 문제는 DFS /BFS 활용해볼 수 있는 문제입니다. 

저는 DFS를 활용하여 재귀로 호출해나가면서 target에 도달하는 경우의수를 더하는 방식으로 문제를 해결하였습니다.


```
private int targetNumber(int[] numbers, int index, int sum) {
        if (numbers.length == index) {
            return (sum == target) ? 1 : 0;
        }

        return targetNumber(numbers, index + 1, sum + numbers[index]) + targetNumber(numbers, index + 1, sum - numbers[index]);
    }
```

https://blog.naver.com/mkzzang0928/222315264660
