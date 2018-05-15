#include "vector.hh"
#include <iostream>

using namespace std;

template <typename T> class queve {
private:
  Vector<T> v;

public:
  queve() : v() {}
  void add(const T &x) { v.add(v.size(), x); }

  void remove() { v.RemoveNaive(0); }

  T get() { return v.get(0); }

  int size() { return v.size(); }
};

int main() {
  queve<int> col;
  col.add(2);
  col.add(3);
  col.add(4);
  cout << col.get() << endl;
  col.remove();
  cout << col.get() << endl;
  col.remove();
  cout << col.get() << endl;
  return 0;
}
