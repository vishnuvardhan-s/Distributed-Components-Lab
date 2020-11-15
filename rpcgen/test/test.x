struct question {
    char q[1000];
};

struct leader {
    char names[100];
    int mark;
};

struct qanda {
    int q;
    int a;
};

struct name {
    char n[100];
};

program test {
    version TEST_VERS {
        void intialize(name)=1;
        question request(int)=2;
        void judge(qanda)=3;
        int score(name)=4;
        leader leaderboard(int)=5;
    }=1;
}=0x23451111;