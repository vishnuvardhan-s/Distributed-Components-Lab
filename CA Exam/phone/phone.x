struct customer {
    char name[100];
    char phone_number[10];
    char address[100];
};
struct name {
    char str[100];
};
program phone {
    version PHONE_VERS {
        customer search(name)=1;
    }=1;
}=0x23451111;