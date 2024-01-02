package org.example.study;

// Scanner BufferedReader 차이점 특징
// https://velog.io/@langoustine/Scanner-VS-BufferedReader 참고해서 작성

/* Scanner
Scanner 클래스는 입력받은 데이터(바이트)를 다양한 타입으로 변환하여 반환하는 클래스이다. 간단하게 기본형과 String 타입을 정규표현식을 사용해 파싱(parse)할 수 있다.

특징
java.util 패키지에 속한다. (java.util.Scanner)
원하는 타입으로 읽을 수 있다.
UnChecked(Runtime) Exception으로 별도로 예외 처리를 명시할 필요가 없다.
Thread unsafe 성질을 지니기에 멀티스레드 환경에서 문제가 발생할 수 있다.
데이터를 입력받을 경우 즉시 사용자에게 전송되며 입력받을 때마다 전송되어야 하기에 많은 시간이 소요된다.
 */

/* BufferedReader
데이터를 한번에 읽어와 버퍼에 보관한 후 버퍼에서 데이터를 읽어오는 방식으로 동작하는 클래스이다. 즉 사용자가 입력한 문자 스트림을 읽는 것(read) 라고 한다.

Buffer?
데이터를 한 곳에서 다른 한 곳으로 전송하는 동안 일시적으로 해당 데이터를 보관하는 임시 메모리 영역이다.
자바에서는 버퍼를 BufferedReader와 BufferedWriter라는 클래스를 제공하여 다룰 수 있다.

특징
java.io 패키지에 속한다. (import java.io.BufferedReader)
데이터를 파싱하지 않고 String으로만 읽고 가져온다.
Checked Exception으로 반드시 예외 처리를 명시해야한다.(I/O Exception을 throw하거나 try/catch 해야한다.)
Thread safe 성질을 지니기에 멀티스레드 환경에서도 안전하다.
버퍼가 가득차거나 개행문자가 나타나면 버퍼의 내용을 한번에 프로그램으로 전달하기에 Scanner보다 소요되는 시간을 절약할 수 있다.
 */

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BufferedReaderAndScanner {
    public static void main(String[] args) throws IOException {

        // Scanner 작성법
        Scanner sc = new Scanner(System.in); // System.in을 통해 Scanner 객체를 생성한다.

        /* System.in?
        사용자로부터 입력을 받기 위한 입력 스트림이다. Scanner 클래스뿐 아니라 다른 입력 클래스들도 System.in을 통해 사용자 입력을 받아야 한다.
         */

        // BufferedReader 작성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*  InputStreamReader 란?
        문자 기반의 보조 스트림으로써 바이트 기반 스트림을 문자 기반 스트림으로 연결시켜 주는 역할을 한다.
         */

        StringTokenizer st  = new StringTokenizer(br.readLine());

        /* StringTokenizer 란?
        문자열을 지정한 구분자로 문자열을 쪼개주는 클래스이다.
        그렇게 쪼개어진 문자열을 우리는 토큰(token)이라고 부른다.
        java.util.StringTokenizer 라이브러리를 import해야 사용할 수 있다.
         */

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(st.nextToken());
        writer.write("\n");
        writer.newLine();
        writer.write(st.nextToken());
        writer.flush();
        writer.close();
        br.close();
    }
}
