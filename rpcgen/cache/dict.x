struct word {
    char s[100];
};

program dict {
    version DICT_VERS {
        word search(word)=1;
    }=1;
}=0x23451111;