### 2월 2주차 정리
---
### BOJ S2 2841 외계인의 기타 연주
#### **Idea**
* 줄별로 프랫을 저장할 수 있는 stack을 N개의 배열로 만든다
* 현재 줄에 프랫이 없을 때 push, cnt++
* 이전 프랫 > 현재 프랫. 현재 프랫보다 이전 프랫이 같거나 작아질때까지 stack에서 pop. cnt++
* 이전 프랫 < 현재 프랫. push, cnt++
* 이전 프랫 == 현재 프랫. 같으면 누를 필요가 없으므로 continue

#### **구현**
<pre>
<code>
Stack<Integer>[] line = new Stack[7];
for(int i=1; i<7; i++)
    line[i] = new Stack<Integer>();
    ...
for(int i = 0; i < N; i++) {
    String[] play = in.readLine().trim().split(" ");
    int ln = Integer.parseInt(play[0]);
    int prat = Integer.parseInt(play[1]);
    
    // 멜로디가 비었을 때 
    if(line[ln].isEmpty()) {
        cnt++;
        line[ln].push(prat);
        
    }else {
        // 이전 프랫 > 현재 프랫
        while(!line[ln].isEmpty() && line[ln].peek() > prat) {
            cnt++;
            line[ln].pop();
        }
        // 이전 프랫 < 현재 프랫. 4 5 7 4 에서 5,7을 pop했을 때 peek()이 현재 프랫과 같을 수 있음. 그러면 cnt++ 하면 안됨. 그렇기 때문에 if로 조건을 걸어줘야 함 
        if(line[ln].isEmpty() || line[ln].peek() < prat) {
            line[ln].push(prat);
            cnt++;
        }
        // 이전프랫 == 현재 프랫
        if(line[ln].peek() == prat)	continue;
    }
}
</code>
</pre>

#### **후기**
> 처음에 문제를 읽고 이해하는게 너무 오래 걸렸다. 어떨때 cnt가 증가하는지 이해하는게 한참 걸려서 힘들었다ㅠㅠ
그리고 이전 프랫보다 현재 프랫이 작으면 pop하고 바로 현재 프랫을 push 했는데 그러니까 오류가 났다. 왜 오류가 났는지 한참 찾았는데 만약 2라는 줄에 프랫이 4 5 7 4 이렇게 쌓여있고 5,7을 pop하면 이전 프랫인 4와 현재 프랫 4가 동일하기 때문에 cnt를 올려주면 안됐다. 
