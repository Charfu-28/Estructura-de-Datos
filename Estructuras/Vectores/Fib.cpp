#include <iostream>
using namespace std;
//************************Fibonacci Recursivo***********************************
int fibRec(int n) {
  if (n <= 2)
    return 1;
  else
    return fibRec(n - 1) + fibRec(n - 2);
}
//*********************Fibonacci Iterativo**************************************
int fiboIt(int n) {
  int a = 0;
  int b = 0;
  int c = 1;

  for (int i = 1; i < n; i++) {
    a = b;
    b = c;
    c = a + b;
  }
  return c;
}
//******************************************************************************
int main() {
  cout << "Fibonacci" << endl;
  int r = fibRec(20);
  int s = fiboIt(20);
  cout << r << endl;
  cout << s << endl;
  return 0;
}
