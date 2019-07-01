# Rick&Morty Coroutines Workshop <img src="https://i.imgur.com/AzeAuJW.png" width="50" alt="logo" align="center">

<p align="center">
  <img src="https://i.imgur.com/bIv8mqz.jpg" width="200" alt="feed">
  <img src="https://i.imgur.com/qwTWTuG.jpg" width="200" alt="detail1">
  <img src="https://i.imgur.com/XuEcHBy.jpg" width="200" alt="detail2">
</p>

# What to do?

It's simple. First, checkout the branch called `rxjava`. 
Then replace all the RxJava code you find by using Coroutines :) You can find useful information <a href="https://github.com/Kotlin/kotlinx.coroutines/blob/master/docs/coroutines-guide.md">here</a> and if you find yourself stuck, one of the possible solutions is in the branch `coroutines`.

The current app is using Model/View/Presenter + Clean Architecture and Koin 2.0 for DI (or just a service locator, ask Jake Warthon). The app is also using Room to persist data and contains the classical Cache/Db or Cloud check in the Repository pattern.

Useful dependencies you'll need:

* `implementation "androidx.room:room-ktx:$roomVersion"` (Adds support for `suspending` functions to Room)
* `implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.0-M2'` (Adds useful objects you will need. Specially if using ViewModels)

## Other considerations

* You will need to write tests. I didn't to force you to do it and not just check them and forget about it. So, take it into account when refactoring ;)
* The app may be a bit... unstable?... Rick&Morty aren't very good devs. You may find things when refactoring. Fix them!


## API

* API used: **Rick&Morty API** (you can check the api documentation <a href="https://rickandmortyapi.com/documentation">here</a>).
* Endpoints used: *"/api/character/"*, *"/api/character/{id}"*


## Third-Party Libraries

* RxKotlin https://github.com/ReactiveX/RxKotlin
* RxJava2 https://github.com/ReactiveX/RxJava
* Koin2 https://github.com/InsertKoinIO/koin
* Coroutines https://github.com/Kotlin/kotlinx.coroutines
* Room https://developer.android.com/topic/libraries/architecture/room
* RxJava / Coroutines Adapters for Retrofit/Room
* Picasso http://square.github.io/picasso/
* Lottie https://airbnb.design/lottie/
* Retrofit2 https://square.github.io/retrofit/
* OkHttp3 https://github.com/square/okhttp

<p align="center">
  <img src="https://i.imgur.com/FCOapKR.jpg" width="200" alt="feed">
  <br>
  <b>Let's play!</b>
</p>
