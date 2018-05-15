#include <chrono>
#include <iostream>

using namespace std;

double fact(double n) {
  if (n <= 1)
    return 1;
  return n * fact(n - 1);
}

int main() {
  cout << "Factorial" << endl;
  std::chrono::time_point<std::chrono::system_clock> start, end;
  start = std::chrono::system_clock::now();
  fact(10);
  end = std::chrono::system_clock::now();
  std::chrono::duration<double> elapsed_seconds = end - start;
  std::cout << "time: " << elapsed_seconds.count() << "s\n";

  return 0;
}
