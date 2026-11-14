class Solution:
    def fib(self, n: int) -> int:
        #Base Case
        if n==0:
            return 0
        if n==1:
            return 1
        #Rec case
        return self.fib(n-1)+self.fib(n-2)
        