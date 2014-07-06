You car run jar from the command line as "java -jar created_jar_name.jar"
Also you can use maven for packaging the project as jar with the commmand "mvn clean compile assembly:single"

Requirements are below:

Türkiye’nin önde gelen kahve firmalarından Kahveci Efendi , satış yazılım sistemini değiştirmek istemektedir. Kahveci Efendi'nin mevcut durumu ve gereksinimleri aşağıdadır;

İçecek çeşitleri
	-Filtre kahve  4 TL
	-Latte    5 TL
	-Mocha 6 TL
	-Çay - 3 TL

Eklentiler
	-Süt  - 2 TL
	-Fındık şurubu - 3 TL
	-Çikolata sosu   - 5 TL

Olası müşteri istekleri
	 - Sütlü filtre kahve
	 - Bol sütlü (2 x süt) Mocha
	 - Sütlü ve fındık şuruplu Latte
	 - Çay
	 - ....
	 - ....

Gereksinimler : 

	-Müşteri sistem üzerinden dilediği kombinasyonda kahve/çay ve diğer eklentileri seçip, sipariş verebilmelidir.
	-Müşteri sipariş verdiği kombinasyonun fiyatını, sipariş bitiminde ekranda görebilmelidir.
	
Teknik istekler:

	-Loglama mekanizması kullanılmalı  (Loglama)
	-Unit test yazılmalı. (Unit Test)
	-“Uygulama zahmetsizce ayağa kalkmalı (ek konfigürasyon gerekmeden)."
