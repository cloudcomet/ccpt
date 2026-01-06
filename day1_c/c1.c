#include<stdio.h>
void main(){
//     int n=2;
//     for(int i=1;i<=10;i++){
//         printf("%d X %d = %d\n",n,i,n*i);
//     }
// int n='C';
// for(int i=1;i<4;i++){
//     for(int j=1;j<4;j++){
//         printf("%c",n);
//     }
//     n--;
    
//     printf("\n");    
// }
// for(int i=1;i<=5;i++){
//     for(int k=1;k<=i;k++){
//         printf("*");
//     }
//     printf("\n");
// }
// for(int i=1;i<=5;i++){
//     for(int j=5;j>=i;j--){
//         printf("*");
//     }
//     printf("\n");
// }
// int n=5;
// for(int i=1;i<=n;i++){
//     for(int j=n;j>=n-i;j--){
//         printf(" ");
//     }
//     for(int k=n;k>=i;k--){
//         printf("*");
//     }
    
    
//     printf("\n");
// }

int n = 5;
// for(int i = 1; i <= n; i++) {
//     for(int j = 1; j <= n - i; j++) {
//         printf(" ");
//     }
//     for(int k = 1; k <= i; k++) {
//         printf("* ");
//     }
//     printf("\n");
// }
// printf("\n");
// for(int i = 1; i <= n; i++){
//     for(int j = 1; j <= n - i; j++) {
//         printf(" ");
//     }
//     for(int k = 1; k <= 2 * i - 1; k++) {
//         printf("*");
//     }
//     printf("\n");
// }

for(int i=1;i<=n;i++){
    for(int j=1;j<=n;j++){
        if(0)
            printf("*");
        else if(j)
            printf("* ");
        else
            printf(" ");
    }
    printf("\n");
    
}



}