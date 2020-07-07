# BarrageToImage
## コード風文字列から弾幕のドット画像を生成します。

sample.txtのような形式で記述されたテキストファイルを用意して、起動引数の一つ目にパスを指定して実行してください。  
mainは com.snowsnowgmail.snowman.barrage.BarrageToImage に有ります。(引数は取りません)  
生成画像の大きさは500 * 500であり、座標もこれに従います。

- \<frame>には動作するフレームを指定する。\<framen>の場合、数字の後に続けてnと書くことで、そのフレームごとに行う。
- \<color>には以下の一文字を指定する。
  - W (White)
  - R (Red)
  - B (Blue)
  - G (Green)
  - Y (Yellow)
  - M (Magenta)
  - C (Cyan)

- 使用できるコード
  - \#barragephoto \<frame> (一番最初に一回だけ記述。このフレームの写真を撮る。)
  - enemyset \<framen> \<x> \<y>  (弾発射位置をここにする。)
  - allway \<framen> \<color> \<speed> \<way> \<startangle> (弾発射位置からstartangleよりway数の全方向弾を放つ。)
  - shot \<framen> \<color> \<speed> \<angle> (弾発射位置からangleの向きの弾を放つ。)
  - copy \<frame> \<frame2> \<frame3> ... (直前のコードと同じ処理をこのフレームで実行する。(引数の数だけコピーされる。))
