#include <iostream>
#include "inputstudy.h"
#include "filestudy.h"
#include "point.h"

using namespace std;

int main()
{
    int *pi = new int[12];
    std::cout << sizeof(pi) << std::endl;
    std::cout << sizeof(*pi) << std::endl;
    delete []pi;

    cout << "Hello World!" << endl;
    return 0;
}

