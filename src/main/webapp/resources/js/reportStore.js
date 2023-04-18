function validateForm() {
  // 상점이름, 주소값을 가져온다
  const storeName = document.getElementById("storeName").value;
  const postCode = document.getElementById("sample4_postcode").value;
  const roadAddress = document.getElementById("sample4_roadAddress").value;
  const jibunAddress = document.getElementById("sample4_jibunAddress").value;
  const detailAddress = document.getElementById("sample4_detailAddress").value;

  // 상점이름, 주소값이 없는 경우
  if (storeName.length === 0) {
    alert("상점 이름을 입력해주세요.");
    return false;
  } else if (postCode.length === 0) {
    alert("우편번호를 입력해주세요.");
    return false;
  } else if (roadAddress.length === 0) {
    alert("도로명주소를 입력하세요")
    return false;
  } else if (jibunAddress.length === 0) {
    alert("지번주소를 입력하세요")
    return false;
  } else if (detailAddress.length === 0) {
    alert("상세주소를 입력하세요")
    return false;
  }

  alert("제보성공")
  return true;
}
