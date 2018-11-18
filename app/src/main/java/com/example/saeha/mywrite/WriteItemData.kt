package com.example.saeha.mywrite

data class WriteItemData(val subject:String,
                         val dateTime:String
) // 이게 그럼 생성자에다가 프로퍼티 선언한건가? 맞네 신기하네

// Jvm에서 파라매터 없는 생성자가 필요한 경우 모든 프로퍼티에 기본 값을 설정해 주면 됨
//ex> 
/*
data class WriteItemData(val subject: String = "", val dateTime: String = "")
 */
