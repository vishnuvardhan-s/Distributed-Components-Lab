struct message {
    char m[1000];
};

program chat {
    version CHAT_VERS {
        message send(message)=1;
    }=1;
}=0x23451111;