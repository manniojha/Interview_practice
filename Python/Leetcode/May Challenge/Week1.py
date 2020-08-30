class Week1():

    #Single Number
    def singleNumber(self, nums) -> int:
        x = 0
        for num in nums:
            x ^= num
        return x

    # Happy Number
    def isHappy(self, n: int) -> bool:
        myset = set()
        while n != 1:
            myset.add(n)
            sum = 0
            while n > 0:
                remainder = n%10
                sum += remainder * remainder
                n//=10
            if sum in myset:
                return False
            n = sum
        return True

    #maximum subarray
    def maxSubArray(self, nums: int) -> int:
        maxx = current_max = nums[0]
        for i in range(1,len(nums)):
            current_max = max(current_max+nums[i],nums[i])
            maxx = max(current_max,maxx)
        return maxx

    # move zeros    
    def moveZeroes(self, nums: int) -> None:
        index = 0
        for i in nums:
            if i != 0:
                nums[index] = i
                index+=1
        while index < len(nums):
            nums[index] = 0
            index+=1

    #Best Time to Buy and Sell Stock I 
    def maxProfit1(self, prices: int) -> int:
        if prices == [] or len(prices) == 1 : return 0
        minn = prices[0]
        result = 0
        for i in range(1,len(prices)):
            minn = min(prices[i],minn)
            result = max(result,prices[i]-minn)
        return result

    #Best Time to Buy and Sell Stock II
    def maxProfit2(self, prices:int) -> int:
        if prices == [] or len(prices) == 1 : return 0
        result = 0
        for i in range(0,len(prices)-1):
            if prices[i] < prices[i+1]:
                result+=prices[i+1]-prices[i]
        return result

    #Group Anagrams:
    def groupAnagrams(self, strs):
        mydict = dict()
        for i in strs:
            sortedWord = "".join(sorted(i))
            if sortedWord not in mydict:
                mydict[sortedWord] = [i]
            else:
                mydict[sortedWord].append(i)
        #result = list()
        # for i in mydict.values():
        #     result.append(i)
        return mydict.values()
    
    #Counting Element
    def countElement(self,arr):
        dict = {}
        for i in arr:
            dict[i]=1
        result = 0
        for x in arr:
            if x+1 in dict:
                result+=1
        return result

if __name__ == "__main__":
    prob = Week1()
    # print(prob.singleNumber([4,1,2,1,2]))
    #print(prob.isHappy(19))
    # print(prob.maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))

    # nums = [0,1,0,3,12]
    # prob.moveZeroes(nums)
    # print(nums)

    # print(prob.maxProfit2([7,1,5,3,6,4]))
    # print(prob.groupAnagrams(["eat","tea","tan","ate","nat","bat"]))
    # print(prob.countElement([1,2,3]))