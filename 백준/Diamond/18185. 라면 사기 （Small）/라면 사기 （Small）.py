N = int(input())
A = list(map(int,input().split()))+[0, 0]

ans = 0
for i in range(N):
    if A[i+1] > A[i+2]:
        sub = min(A[i], A[i+1]-A[i+2])
        A[i] -= sub; A[i+1] -= sub; ans += sub*5

        sub = min(A[i], A[i+1], A[i+2])
        A[i] -= sub; A[i+1] -= sub; A[i+2] -= sub; ans += sub*7

    else:
        sub = min(A[i], A[i+1], A[i+2])
        A[i] -= sub; A[i+1] -= sub; A[i+2] -= sub; ans += sub*7

        sub = min(A[i], A[i+1])
        A[i] -= sub; A[i+1] -= sub; ans += sub*5

    ans += A[i]*3; A[i] = 0
 
print(ans)
