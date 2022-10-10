#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
int main(int argc, char const *argv[])
{
    fprintf(stdout,"Mi pid %d\n", getpid());
    char * parametros[]={"firefox","https://www.marca.com","https://www.as.com"};
    execv("/usr/bin/firefox",parametros);
    return 0;
}