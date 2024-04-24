package com.cookandroid.project4_1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    //lateinit : 변수 초기화 나중으로 미룸.
    // 따라서 여기 적어둔 UI컴포넌트(EditText, Button, TextView 등)은 onCreate() 메서드에서 초기화됨.
    lateinit var edit1: EditText
    lateinit var edit2: EditText
    lateinit var btnAdd: Button
    lateinit var btnSub: Button
    lateinit var btnMul: Button
    lateinit var btnDiv: Button
    lateinit var btnRem: Button
    lateinit var textResult: TextView

    // EditText 컴포넌트에서 입력받은 텍스트는 항상 문자열 형태(String)임. 따라서 사용자 입력을 직접 int 또는 double과 같은 숫자 타입으로 초기화하는 것은 직접적으로 불가능.
    // 입력 필드(EditText)에서 가져온 데이터는 String 타입이기 때문에, 숫자로 사용하기 위해서는 반드시 적절한 숫자 형식으로 변환해야 함.
    lateinit var num1: String
    lateinit var num2: String
    var result: Double? = null // 계산 결과 저장. null을 허용(? 표시)하여 초기에는 값이 없음을 나타냄.

    //
   // C:\Users\Administrator\AndroidStudioProjects\project4_1\app\build\intermediates\compile_and_runtime_not_namespaced_r_class_jar\debug\processDebugResources\R.jarC:\Users\Administrator\AndroidStudioProjects\project4_1\app\build\intermediates\compile_and_runtime_not_namespaced_r_class_jar\debug\processDebugResources\R.jar


    // onCreate() :  액티비티가 생성될 때 호출. 이 메서드 내에서 UI 컴포넌트를 초기화하고, 버튼 클릭 이벤트 핸들러를 설정
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // activity_main.xml 레이아웃 파일을 사용하여 UI를 설정.
        title = "초간단 계산기"

        //findViewById<T>(): XML 레이아웃에서 각 컴포넌트의 ID를 사용하여 인스턴스를 찾고 초기화.
        edit1 = findViewById<EditText>(R.id.Edit1)
        edit2 = findViewById<EditText>(R.id.Edit2)

        btnAdd = findViewById<Button>(R.id.BtnAdd)
        btnSub = findViewById<Button>(R.id.BtnSub)
        btnMul = findViewById<Button>(R.id.BtnMul)
        btnDiv = findViewById<Button>(R.id.BtnDiv)
        btnRem = findViewById<Button>(R.id.BtnRem)

        textResult = findViewById<TextView>(R.id.TextResult)


        /*버튼 클릭 리스너 = 사용자가 버튼을 눌렀을 때 호출되는 콜백 함수.
        각 버튼(btnAdd, btnSub, btnMul, btnDiv, btnRem)에는 setOnClickListener가 설정되어 있어, 해당 버튼이 클릭되면 실행될 코드 블록을 정의

                작동 방식
                입력 값 가져오기: edit1과 edit2에서 사용자가 입력한 텍스트를 가져옴
                입력 검증: 입력 값이 비었는지 확인하고, 비어 있으면 Toast 메시지를 통해 사용자에게 알림.
                계산 실행: 입력 값이 유효한 경우, 적절한 연산을 수행.
                나누기(btnDiv)와 나머지(btnRem) 연산에서는 분모가 0인지 추가로 검사.
                결과 표시: textResult TextView에 결과를 표시.*/

        btnAdd.setOnClickListener {
            num1 =
                edit1.text.toString() //(EditText 객체)에서 사용자가 입력한 텍스트를 Editable 타입에서 String 타입으로 변환하여 num1에 저장.
            //edit1.text는 EditText에서 현재 입력된 텍스트를 나타내는 속성.  이 속성의 타입은 Editable로, 텍스트의 수정 가능한 내용을 담고 있음
            num2 = edit2.text.toString()

            // num1과 num2를 trim() 함수를 사용해 앞뒤 공백을 제거한 후, 둘 중 하나라도 빈 문자열인지 확인. trim()은 문자열 앞뒤의 공백을 제거하여 실제 유의미한 내용만 남김.
            if (num1.trim() == "" || num2.trim() == "") {
                Toast.makeText(applicationContext, "입력 값이 비었습니다", Toast.LENGTH_SHORT)
                    .show()
            //만약 num1 또는 num2가 비어 있으면, 사용자에게 입력 값이 비었다는 메시지를 표시하는 토스트 알림을 생성하고 보여줌.
            // Toast.LENGTH_SHORT는 표시되는 시간을 짧게 설정.

            } else {
                result = num1.toDouble() + num2.toDouble() //여기에서 num1과 num2를 문자열에서 실수로 변환.
                textResult.text = "계산 결과 : " + result.toString() // 계산 결과 result를 다시 문자열로 변환.
                //activity_main.xml의 textResult의 text를 "계산 결과 : " + result.toString()로 변경하여 표시함.
            }
        }

        btnSub.setOnClickListener {
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()

            // num1이나 num2가 비어 있다면
            if (num1.trim() == "" || num2.trim() == "") {
                Toast.makeText(applicationContext, "입력 값이 비었습니다", Toast.LENGTH_SHORT)
                    .show()
            } else {
                result = num1.toDouble() - num2.toDouble()
                textResult.text = "계산 결과 : " + result.toString()
            }
        }

        btnMul.setOnClickListener {
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            // num1이나 num2가 비어 있다면
            if (num1.trim() == "" || num2.trim() == "") {
                Toast.makeText(applicationContext, "입력 값이 비었습니다", Toast.LENGTH_SHORT)
                    .show()
            } else {
                result = num1.toDouble() * num2.toDouble()
                textResult.text = "계산 결과 : " + result.toString()
            }
        }

        btnDiv.setOnClickListener {
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            // num1이나 num2가 비어 있다면
            if (num1.trim() == "" || num2.trim() == "") {
                Toast.makeText(applicationContext, "입력 값이 비었습니다", Toast.LENGTH_SHORT)
                    .show()
            } else {
                // 예외처리. num2가 0이면 나누지 않는다.
                if (num2.trim() == "0") { //나누기와 나머지 연산에서 0으로 나눌 경우 사용자에게 경고하는 Toast 메시지를 표시.
                    Toast.makeText(
                        applicationContext,
                        "0으로 나누면 안됩니다!", Toast.LENGTH_SHORT
                    ).show()
                } else {
                    result = num1.toDouble() / num2.toDouble()
                    result =
                        (result!! * 10).toInt() / 10.0 // 소수점 아래 1자리까지만 출력. result!!는 result가 널이 아님을 명시.
                    textResult.text = "계산 결과 : " + result.toString()
                }
            }
        }

        btnRem.setOnClickListener {
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            // num1이나 num2가 비어 있다면
            if (num1.trim() == "" || num2.trim() == "") {
                Toast.makeText(applicationContext, "입력 값이 비었습니다", Toast.LENGTH_SHORT)
                    .show()
            } else {
                // num2가 0이면 나누지 않는다.
                if (num2.trim() == "0") {
                    Toast.makeText(
                        applicationContext,
                        "0으로 나머지 값 안됩니다!", Toast.LENGTH_SHORT
                    ).show()
                } else {
                    result = num1.toDouble() % num2.toDouble()
                    textResult.text = "계산 결과 : " + result.toString()
                }
            }
        }

    }

}