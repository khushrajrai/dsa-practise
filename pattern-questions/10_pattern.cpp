#include <iostream>
using namespace std;

// Pattern

//    *
//   ***
//  *****
// *******
//  *****
//   ***
//    *

int main()
{
    int n = 5;
    // cin >> n;
    int row = 1;

    // Upper Part
    while (row <= n)
    {
        int space = n - row;
        while (space)
        {
            cout << " ";
            space--;
        }
        int star = 1;
        while (star <= (2 * row - 1))
        {
            cout << "*";
            star++;
        }
        cout << endl;
        row++;
    }

    // Lower part

    row = n - 1;
    while (row >= 1)
    {
        int space = n - row;
        while (space)
        {
            cout << " ";
            space--;
        }

        int star = 1;
        while (star <= (2 * row - 1))
        {
            cout << "*";
            star++;
        }
        cout << endl;
        row--;
    }
    return 0;
}