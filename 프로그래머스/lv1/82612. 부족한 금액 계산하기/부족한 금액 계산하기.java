class Solution {
    public long solution(int price, int money, int count) { 
       long temp = 0;
        for(int i = 1; i <= count; i++)
        {
            temp += i * price;            
        }
        
        if (temp > money)
            return temp-money;
        
        else return 0;
    }
}