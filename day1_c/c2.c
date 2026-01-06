#include<stdio.h>
#include "c2.h"
void func(int n)
{
    int no=n;
    int res=no%10;
    if(res%2==0)
        printf("The last Digit is %d and it is even.",res);
    else
        printf("The last digit is %d and it is odd.",res);
}

int checkArmstrong(int num){
    int original = num, sum = 0, digits = 0;
    int temp = num;
    
    while(temp > 0) {
        digits++;
        temp /= 10;
    }
    
    temp = num;
    while(temp > 0) {
        int digit = temp % 10;
        int power = 1;
        for(int i = 0; i < digits; i++) {
            power *= digit;
        }
        sum += power;
        temp /= 10;
    }
    
    if(sum == original)
        printf("%d is an Armstrong number.\n", num);
    else
        printf("%d is not an Armstrong number.\n", num);
    
    return sum == original;
}

void main(){
    // int n;
    // printf("Enter a number:");
    // scanf("%d",&n);
    // func(n);

    printevensum();
}
void printevensum()
{
    // print sum of even numbers upto 50
    int sum = 0;
    for (int i = 2; i <= 50; i += 2)
    {
        sum += i;
    }
    printf("Sum of even numbers upto 50: %d\n", sum);
}