struct word {
    char str[100];
};
struct courses {
    char name[100];
    char faculty[100];
    struct word students[100];
    int size;
};
struct arg {
    char studentName[100];
    char courseName[100];
};
program coursereg {
    version COURSEREG_VERS {
        int admit(struct arg)=1;
        struct word view(struct word)=2;
    }=1;
}=0x23451111;