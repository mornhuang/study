#include <iostream>

using namespace std;

#include <afx.h>
#include <stdio.h>

int main() {
    int lo, hi;
    CString str;
    CStdioFile fFibo;

    fFibo.Open("FIBO.DAT", CFile::modeWrite |CFile::modeCreate
            |CFile::typeText);
    str.Format("%s\n", "Fib Seq , less than 100 :");
    printf("%s", (LPCTSTR) str);
    fFibo.WriteString(str);

    lo = hi = 1;
    str.Format("%d\n", lo);
    printf("%s", (LPCTSTR)str);
    fFibo.WriteString(str);

    while (hi < 100) {
        str.Format("%d\n", hi);
        printf("%s", (LPCTSTR)str);
        fFibo.WriteString(str);
        hi = lo + hi;
        lo = hi - lo;
    }

    fFibo.Close();
    return 0;
}


