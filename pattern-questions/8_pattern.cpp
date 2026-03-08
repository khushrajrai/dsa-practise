#include <iostream>
using namespace std;

// * * * 4
// * * 4 3
// * 4 3 2
// 4 3 2 1

int main()
{
    int n;
    cin >> n;
    int row = 1;
    while (row <= n)
    {
        int space = n - row;
        int col = 1;
        while (space)
        {
            cout << "*" << " ";
            space--;
        }
        while (col <= row)
        {
            cout << n - col + 1 << " ";
            col++;
        }
        cout << endl;
        row++;
    }
}