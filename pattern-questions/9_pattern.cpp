#include <iostream>
using namespace std;

//     1
//    23
//   345
//  4567

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
            cout << " " << " ";
            space--;
        }
        while (col <= row)
        {
            cout << row + col - 1 << " ";
            col++;
        }
        cout << endl;
        row++;
    }
}