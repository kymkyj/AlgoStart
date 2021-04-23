## 문제풀이
입력 값에 대한 순열을 담습니다. 중복이 없는 자료 구조인 Set을 활용합니다. 

```
private void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        if(!prefix.equals("")) set.add(Integer.valueOf(prefix));
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);
    }
```

Set에 담긴 순열에서 소수를 찾고 카운트를 증가시킵니다. 

```
set.stream().filter(this::isPrime).count();

private boolean isPrime(int num) {
        if (num == 0 || num == 1)  {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
```


https://blog.naver.com/mkzzang0928/222315257436
