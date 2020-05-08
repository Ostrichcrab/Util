#include <arpa/inet.h>
#include <string.h>

using namespace std;

int main() {
  int N = 0;
  cin >> N;
  while (N--) {
    char str[10101]; 
    scanf("%s", str);
    in6_addr addr;
    inet_pton(AF_INET6, str, &addr);

    for (int i = 0; i < 16; i++) {
      printf("%02x", (int)addr.s6_addr[i]);
      if (i % 2 == 1 && i != 15) {
        printf(":");
      }

    }
      printf("\n");

  }
}
