#include "vector.hh"
#include <iostream>

using namespace std;

template <typename T> class stack {
private:
  Vector<T> v;

public:
  stack() : v() {}
  void add(const T &x) { v.add(v.size(), x); }

  void remove() { v.remove(v.size() - 1); }

  T get() { return v.get(v.size() - 1); }

  int size() { return v.size(); }
};

int main() {
  stack<int> pila;
  pila.add(2);
  pila.add(3);
  cout << pila.get() << endl;
  pila.remove();
  cout << pila.get() << endl;
  return 0;
}
