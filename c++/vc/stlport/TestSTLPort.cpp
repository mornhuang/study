// TestSTLPort.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"

#include <iostream> 
#include <rope> 
using namespace std; 
int main() 
{ 
    // crope就是容纳char类型字符的rope容器 
    crope bigstr1("Hello"); 
    crope bigstr2("World"); 
    crope story = bigstr1 + " " + bigstr2; 
    cout << story << endl; 
	system("pause"); 
	return 0; 
}

