# Tutorial APAP

## Authors

- **Syndi Yohana Sitorus** - _1906353656_ - _C_

---

## Tutorial 2

### What I have learned today

Yang saya pelajari hari ini adalah mengenai konsep MVC secara lebih mendalam dengan menggunakan framework springboot. Selain itu, saya juga memepelajari bagaimana cara membuat service layer sebagai mediator antara controller dan database.

### Pertanyaan 1: Cobalah untuk menambahkan sebuah Bioskop dengan mengakses link berikut: http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20 APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx&jumlahStudio=10 Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi

Ketika mengakses link tersebut, terjadi eror berupa Whitelabel Error Page. Hal ini terjadi karena
tidak ada template yang dapat diakses oleh method add page. Pada method tersebut, seharusnya
direturn page html, tetapi karena belum ada template yang dibuat sesuai dengan nama filenya, maka
akan page menghasilkan eror.

### Pertanyaan 2: Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat

Menurut saya, @Autowired pada class Controller merupakan implementasi dari Dependecy Injection. Cara kerjanya adalah, ketika interface BioskopService (dependency) ingin diimplementasikan ke setiap kelas pada controller, maka @Autowired cukup dianotasikan pada class Controller sehingga dapat mengimplementasikan bioskopService secara terus menerus tanpa harus mendefine nya terlebih dahulu.

### Pertanyaan 3: Cobalah untuk menambahkan sebuah Bioskop dengan mengakses link berikut: http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20 APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.

Ketika mengakses link tersebut, terjadi eror berupa Whitelabel Error Page. Hal ini terjadi karena tidak adanya parameter jumlahStudio ketika ingin menambahkan data bioskop. Ketika salah satu parameter
dihilangkan, maka input tidak akan sesuai dengan method yang akan diproses karena ketidaksesuaian
parameternya, sehingga data tidak dapat ditambahkan.

### Pertanyaan 4: Jika Papa APAP ingin melihat Bioskop dengan nama Bioskop Maung, link apa yang harus diakses?

Link yang harus diakses adalah http://localhost:8080/bioskop/view?idBioskop=1 , jika dalam hal ini
bioskop Maung memiliki id 1. Hal ini disesuaikan dengan request mapping untuk menjalankan method detail page.

### Pertanyaan 5: Tambahkan 1 contoh Bioskop lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/bioskop/viewall , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.

Ketika mengakses link tersebut, maka akan ditampilkan seluruh data bioskop yang sudah ditambahkan.
![alt text](https://user-images.githubusercontent.com/71598534/133463316-480e2540-4bfa-49aa-bc0d-43bd5ed6b1a3.PNG)
![alt text](https://user-images.githubusercontent.com/71598534/133463375-bfc91526-a6a5-470b-8baa-5992ea260d60.PNG)

### What I did not understand

Sampai tahap ini, saya sudah mulai paham bagaimana proses atau keterkaitan MVC serta service layer. Namun saya belum terlalu paham secara mendalam proses dibalik autowired pada class controller.

- [x] Proses Maven
- [ ] Dependency Injection
- [ ] Proses Autowired

### Source

-

## Tutorial 1

### What I have learned today

Yang saya pelajari hari ini adalah mengenai operasi-operasi penting pada git, seperti branch,
checkout, serta revert. Saya juga mempelajari bagaimana fungsi github dan development flow
penggunaan github. Selain itu, saya mempelajari bagaimana proses setup spring boot dengan
menggunakan maven pada local environment saya.

### Github

1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
   Issue tracker adalah suatu tab pada github yang dapat digunakan untuk mencatat atau membuat
   issue baru ketika terjadi suatu masalah sehingga permintaan perubahan ataupun masalah tersebut
   dapat ditrack dengan mudah.
   Masalah yang dapat diselesaikan seperti bugs (eror yang terjadi) serta enhancements track.

2. Apa perbedaan dari git merge dan git merge --squash?
   Git merge dan git merge --squash memiliki fungsi yang sama, yaitu menggabungkan atau me-merge
   suatu branch ke branch utama (main). Perbedaannya terletak pada history commitnya. Ketika
   melakukan git merge, commit dari branch dan commit dari master akan digabungkan, sehingga
   commit yang dihasilkan tidak bersih (clean), sedangkan ketika git merge --squash dilakukan,
   maka commit yang diambil berasal dari branch buatan saja sehingga akan menghasilkan clean commit.

3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan
   suatu aplikasi?
   Dengan menggunakan git, kita menjadi tahu bagaimana perubahan terhadap source code yang telah
   kita buat sebelumnya, sehingga kita dapat mengatur versi dari source code yang kita gunakan
   dan dapat memberi tanda pada code yang kita edit atau tambah. Dengan adanya git, akan mempermudah
   kita ketika berkolaborasi dengan tim untuk melakukan update secara realtime pada kodingan kita.
   Penggunaan git pun sederhana dan memiliki design yang dapat dipahami dengan mudah.

### Spring

1. Apa itu library & dependency?
   Library adalah suatu package yang tersedia yang terdiri dari kelas-kelas atau program-program terdefinisi untuk dapat digunakan kembali pada suatu file java. Kelas-kelas tersebut harus terlebih dahulu diimpor agar dapat digunakan sesuai dengan namanya.
   Dependency adalah suatu kelas atau objek yang dapat digunakan atau suatu kelas dimana kelas lain bergantung padanya. Misalnya terdapat kelas A yang bergantung pada kelas B, maka kelas B disebut
   dependency karena tanpa kelas B, kelas A tidak dapat berjalan.

2. Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
   Maven adalah suatu build tools pada java yang digunakan untuk membangun suatu project dari IDE
   manapun. Maven menggunakan konsep POM(Project Object Model) yang berisi konfigurasi serta
   informasi pada project tersebut.
   Dengan menggunakan maven, kita dapat membangun suatu proyek dengan mudah karena dapat menambah
   dependensi lain dengan mudah. Selain itu, proyek kita dapat terintegrasi dengan adanya maven
   sehingga memudahkan kolaborasi program dengan berbagai IDE yang berbeda.
   Terdapat beberapa alternative dari Maven, yaitu Anzure DevOps Server, G2 Deals, Red Hat Ansible
   Automation Platform, dll.

3. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring
   framework?
   Spring Framework juga dapat mengembangkan koneksi database dengan memanfaatkan fitur Dependency
   Injection atau Java Inversion of Control (IoC).
   Spring Framework juga dapat melakukan manajemen transaksi menggunakan abstract layer.
   Selain itu, dengan adanya Spring Framework, dapat dikembangkan framework-framework pendukung
   ekosistem spring yang lain, seperti spring session, spring mobile, spring batch, dll.

4. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya
   menggunakan @RequestParam atau @PathVariable?
   @RequestParam digunakan untuk mendapatkan/mengekstrak data dengan menerima parameter query yang
   sudah ditentukan pada Controller's handler nya, sedangkan @PathVariable digunakan untuk mengekstrak
   nilai apapun yang telah disematkan pada URL atau template URL.
   @RequestParam sebaiknya digunakan ketika menggunakan method GET, namun @PathVariable sebaiknya
   digunakan ketika menggunakan method GET dan Delete. Selain itu, @RequestParam lebih sering digunakan
   untuk tradisional web (logic berada pada sever) sedangkan @PathVariable lebih cocok digunakan
   untuk web service seperti RESTful yang mana URL nya berisi nilai asli.

### What I did not understand

Ada beberapa hal yang belum saya terlalu mengerti prosesnya, seperti Maven serta Dependency
Injection. Hal tersebut karena saya hanya mengikuti step-step pada tutorial ini, sehingga tidak
terlalu memahami proses yang terjadi di baliknya.

- [ ] Proses Maven
- [ ] Dependency Injection

### Source

## Tutorial

### What I have learned today

Yang saya pelajari hari ini adalah mengenai operasi-operasi penting pada git, seperti branch,
checkout, serta revert. Saya juga mempelajari bagaimana fungsi github dan development flow
penggunaan github. Selain itu, saya mempelajari bagaimana proses setup spring boot dengan
menggunakan maven pada local environment saya.

### Github

1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
   Issue tracker adalah suatu tab pada github yang dapat digunakan untuk mencatat atau membuat
   issue baru ketika terjadi suatu masalah sehingga permintaan perubahan ataupun masalah tersebut
   dapat ditrack dengan mudah.
   Masalah yang dapat diselesaikan seperti bugs (eror yang terjadi) serta enhancements track.

2. Apa perbedaan dari git merge dan git merge --squash?
   Git merge dan git merge --squash memiliki fungsi yang sama, yaitu menggabungkan atau me-merge
   suatu branch ke branch utama (main). Perbedaannya terletak pada history commitnya. Ketika
   melakukan git merge, commit dari branch dan commit dari master akan digabungkan, sehingga
   commit yang dihasilkan tidak bersih (clean), sedangkan ketika git merge --squash dilakukan,
   maka commit yang diambil berasal dari branch buatan saja sehingga akan menghasilkan clean commit.

3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan
   suatu aplikasi?
   Dengan menggunakan git, kita menjadi tahu bagaimana perubahan terhadap source code yang telah
   kita buat sebelumnya, sehingga kita dapat mengatur versi dari source code yang kita gunakan
   dan dapat memberi tanda pada code yang kita edit atau tambah. Dengan adanya git, akan mempermudah
   kita ketika berkolaborasi dengan tim untuk melakukan update secara realtime pada kodingan kita.
   Penggunaan git pun sederhana dan memiliki design yang dapat dipahami dengan mudah.

### Spring

1. Apa itu library & dependency?
   Library adalah suatu package yang tersedia yang terdiri dari kelas-kelas atau program-program terdefinisi untuk dapat digunakan kembali pada suatu file java. Kelas-kelas tersebut harus terlebih dahulu diimpor agar dapat digunakan sesuai dengan namanya.
   Dependency adalah suatu kelas atau objek yang dapat digunakan atau suatu kelas dimana kelas lain bergantung padanya. Misalnya terdapat kelas A yang bergantung pada kelas B, maka kelas B disebut
   dependency karena tanpa kelas B, kelas A tidak dapat berjalan.

2. Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
   Maven adalah suatu build tools pada java yang digunakan untuk membangun suatu project dari IDE
   manapun. Maven menggunakan konsep POM(Project Object Model) yang berisi konfigurasi serta
   informasi pada project tersebut.
   Dengan menggunakan maven, kita dapat membangun suatu proyek dengan mudah karena dapat menambah
   dependensi lain dengan mudah. Selain itu, proyek kita dapat terintegrasi dengan adanya maven
   sehingga memudahkan kolaborasi program dengan berbagai IDE yang berbeda.
   Terdapat beberapa alternative dari Maven, yaitu Anzure DevOps Server, G2 Deals, Red Hat Ansible
   Automation Platform, dll.

3. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring
   framework?
   Spring Framework juga dapat mengembangkan koneksi database dengan memanfaatkan fitur Dependency
   Injection atau Java Inversion of Control (IoC).
   Spring Framework juga dapat melakukan manajemen transaksi menggunakan abstract layer.
   Selain itu, dengan adanya Spring Framework, dapat dikembangkan framework-framework pendukung
   ekosistem spring yang lain, seperti spring session, spring mobile, spring batch, dll.

4. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya
   menggunakan @RequestParam atau @PathVariable?
   @RequestParam digunakan untuk mendapatkan/mengekstrak data dengan menerima parameter query yang
   sudah ditentukan pada Controller's handler nya, sedangkan @PathVariable digunakan untuk mengekstrak
   nilai apapun yang telah disematkan pada URL atau template URL.
   @RequestParam sebaiknya digunakan ketika menggunakan method GET, namun @PathVariable sebaiknya
   digunakan ketika menggunakan method GET dan Delete. Selain itu, @RequestParam lebih sering digunakan
   untuk tradisional web (logic berada pada sever) sedangkan @PathVariable lebih cocok digunakan
   untuk web service seperti RESTful yang mana URL nya berisi nilai asli.

### What I did not understand

Ada beberapa hal yang belum saya terlalu mengerti prosesnya, seperti Maven serta Dependency
Injection. Hal tersebut karena saya hanya mengikuti step-step pada tutorial ini, sehingga tidak
terlalu memahami proses yang terjadi di baliknya.

- [ ] Proses Maven
- [ ] Dependency Injection

### Source

## Tutorial 1

### What I have learned today

Yang saya pelajari hari ini adalah mengenai operasi-operasi penting pada git, seperti branch,
checkout, serta revert. Saya juga mempelajari bagaimana fungsi github dan development flow
penggunaan github. Selain itu, saya mempelajari bagaimana proses setup spring boot dengan
menggunakan maven pada local environment saya.

### Github

1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
   Issue tracker adalah suatu tab pada github yang dapat digunakan untuk mencatat atau membuat
   issue baru ketika terjadi suatu masalah sehingga permintaan perubahan ataupun masalah tersebut
   dapat ditrack dengan mudah.
   Masalah yang dapat diselesaikan seperti bugs (eror yang terjadi) serta enhancements track.

2. Apa perbedaan dari git merge dan git merge --squash?
   Git merge dan git merge --squash memiliki fungsi yang sama, yaitu menggabungkan atau me-merge
   suatu branch ke branch utama (main). Perbedaannya terletak pada history commitnya. Ketika
   melakukan git merge, commit dari branch dan commit dari master akan digabungkan, sehingga
   commit yang dihasilkan tidak bersih (clean), sedangkan ketika git merge --squash dilakukan,
   maka commit yang diambil berasal dari branch buatan saja sehingga akan menghasilkan clean commit.

3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan
   suatu aplikasi?
   Dengan menggunakan git, kita menjadi tahu bagaimana perubahan terhadap source code yang telah
   kita buat sebelumnya, sehingga kita dapat mengatur versi dari source code yang kita gunakan
   dan dapat memberi tanda pada code yang kita edit atau tambah. Dengan adanya git, akan mempermudah
   kita ketika berkolaborasi dengan tim untuk melakukan update secara realtime pada kodingan kita.
   Penggunaan git pun sederhana dan memiliki design yang dapat dipahami dengan mudah.

### Spring

1. Apa itu library & dependency?
   Library adalah suatu package yang tersedia yang terdiri dari kelas-kelas atau program-program terdefinisi untuk dapat digunakan kembali pada suatu file java. Kelas-kelas tersebut harus terlebih dahulu diimpor agar dapat digunakan sesuai dengan namanya.
   Dependency adalah suatu kelas atau objek yang dapat digunakan atau suatu kelas dimana kelas lain bergantung padanya. Misalnya terdapat kelas A yang bergantung pada kelas B, maka kelas B disebut
   dependency karena tanpa kelas B, kelas A tidak dapat berjalan.

2. Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
   Maven adalah suatu build tools pada java yang digunakan untuk membangun suatu project dari IDE
   manapun. Maven menggunakan konsep POM(Project Object Model) yang berisi konfigurasi serta
   informasi pada project tersebut.
   Dengan menggunakan maven, kita dapat membangun suatu proyek dengan mudah karena dapat menambah
   dependensi lain dengan mudah. Selain itu, proyek kita dapat terintegrasi dengan adanya maven
   sehingga memudahkan kolaborasi program dengan berbagai IDE yang berbeda.
   Terdapat beberapa alternative dari Maven, yaitu Anzure DevOps Server, G2 Deals, Red Hat Ansible
   Automation Platform, dll.

3. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring
   framework?
   Spring Framework juga dapat mengembangkan koneksi database dengan memanfaatkan fitur Dependency
   Injection atau Java Inversion of Control (IoC).
   Spring Framework juga dapat melakukan manajemen transaksi menggunakan abstract layer.
   Selain itu, dengan adanya Spring Framework, dapat dikembangkan framework-framework pendukung
   ekosistem spring yang lain, seperti spring session, spring mobile, spring batch, dll.

4. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya
   menggunakan @RequestParam atau @PathVariable?
   @RequestParam digunakan untuk mendapatkan/mengekstrak data dengan menerima parameter query yang
   sudah ditentukan pada Controller's handler nya, sedangkan @PathVariable digunakan untuk mengekstrak
   nilai apapun yang telah disematkan pada URL atau template URL.
   @RequestParam sebaiknya digunakan ketika menggunakan method GET, namun @PathVariable sebaiknya
   digunakan ketika menggunakan method GET dan Delete. Selain itu, @RequestParam lebih sering digunakan
   untuk tradisional web (logic berada pada sever) sedangkan @PathVariable lebih cocok digunakan
   untuk web service seperti RESTful yang mana URL nya berisi nilai asli.

### What I did not understand

Ada beberapa hal yang belum saya terlalu mengerti prosesnya, seperti Maven serta Dependency
Injection. Hal tersebut karena saya hanya mengikuti step-step pada tutorial ini, sehingga tidak
terlalu memahami proses yang terjadi di baliknya.

- [ ] Proses Maven
- [ ] Dependency Injection

### Source

https://idcloudhost.com/mengenal-apa-itu-git-serta-manfaat-dan-fiturnya-untuk-developer/
https://www.termasmedia.com/pemrograman/java/118-pengertian-fungsi-dan-kegunaan-paket-package-di-java.html
http://tutorials.jenkov.com/ood/understanding-dependencies.html#whatis
https://www.it-swarm-id.com/id/git/bagaimana-cara-menggunakan-git-merge-squash/971467548/
https://medium.com/@acep.abdurohman90/mengenal-maven-sebagai-java-build-tools-5ba752f75812
https://www.geeksforgeeks.org/introduction-apache-maven-build-automation-tool-java-projects/
https://www.g2.com/products/apache-maven/competitors/alternatives
https://medium.com/idspring/mengapa-spring-framework-f3411b5e40ab
https://teknojurnal.com/spring-framework-java/
https://socs.binus.ac.id/2017/10/04/framework-spring-java/
https://www.javacodegeeks.com/2017/10/differences-requestparam-pathvariable-annotations-spring-mvc.html
https://edupro.id/questions/3370312/perbedaan-antara-pathvariable-requestparam-dan-requestbody
