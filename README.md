# BarrageToImage
## コード風文字列から弾幕のドット画像を生成します。

カレントディレクトリにcode.txtをsample.txtのような形式で記述してから実行してください。  
mainは com.snowsnowgmail.snowman.barrage.BarrageToImage に有ります。(引数は取りません)  

- \<frame\>には動作するフレームを指定する。\<framen\>の場合、数字の後に続けてnと書くことで、そのフレームごとに行う。
- \<color\>には以下の一文字を指定する。
  - W (White)
  - R (Red)
  - B (Blue)
  - G (Green)
  - Y (Yellow)
  - M (Magenta)
  - C (Cyan)

- 使用できるコード
  - #barragephoto \<frame\> (一番最初に一回だけ記述。このフレームの写真を撮る。)
  - enemyset \<frame\> \<x\> \<y\>  (弾発射位置をここにする。)
  - allway \<frame\> \<color\> \<speed\> \<way\> \<startangle\> (弾発射位置からstartangleよりway数の全方向弾を放つ。)
  - copy \<frame\> \<frame2\> \<frame3\> ... (直前のコードと同じ処理をこのフレームで実行する。(引数の数だけコピーされる。))
