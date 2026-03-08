#include <iostream>
using namespace std;

// 1 2 3 4 5 5 4 3 2 1
// 1 2 3 4 * * 4 3 2 1
// 1 2 3 * * * * 3 2 1
// 1 2 * * * * * * 2 1
// 1 * * * * * * * * 1

int main()
{
    int n = 5;
    // cin >> n;
    int row = 1;
    while (row <= n)
    {
        int col = 1;
        while (col <= n - row + 1)
        {
            cout << col << " ";
            col++;
        }
        int star = 1;
        while (star <= (2 * row - 2))
        {
            cout << "* ";
            star++;
        }
        int col2 = n - row + 1;
        while (col2 >= 1)
        {
            cout << col2 << " ";
            col2--;
        }
        cout << endl;
        row++;
    }
    return 0;
}
