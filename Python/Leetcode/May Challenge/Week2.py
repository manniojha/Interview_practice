class Week2():
    # backspaceCompare
    def backspaceCompare(self, S: str, T: str) -> bool:
        return self.backspace(S) == self.backspace(T)

    def backspace(self,S: str) -> str:
        result,counter = "",0
        for i in range(len(S)-1,-1,-1):
            if S[i] == '#':
                counter-=1
            elif counter != 0:
                counter+=1
            else:
                result+=S[i]
        return result
    #Last Stone Weight
    def lastStoneWeight(self, stones: List[int]) -> int:
        size = len(stones)
        for i in range(size):
            stones[i] = -stones[i]
        heapq.heapify(stones)
        while size>=2:
            x = -heapq.heappop(stones)
            y = -heapq.heappop(stones)
            if x == y:
                size-=2
            else:
                size-=1
                heapq.heappush(stones,-(x-y))
        if size == 0:
            return 0
        return -heapq.heappop(stones)

if __name__ == "__main__":
    prob = Week2()
    print(prob.backspaceCompare('a#c','b'))