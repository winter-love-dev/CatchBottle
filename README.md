# CatchBottle

<img width="1691" alt="thumb" src="https://github.com/winter-love-dev/CatchBottle/assets/26156815/6e0d3f8a-235d-415d-b3da-d05d93b9d5eb">

</br>

### <b>'Catch Bottle'</b> project is a great way to enjoy my favorite whiskey and programming together.
Concept: Alcohol sales commerce
</br>
Design reference, Banner image asset from [DailyShot](https://dailyshot.co/) Service


---
</br>

## Some screen recording

<div align="left">

| Enter your nickname to enter the 'Catch Bottle' world | You can explore banner events and alcohol information |
| :---------------: | :---------------: |
| <img src="https://github.com/winter-love-dev/CatchBottle/assets/26156815/4fb48691-98a2-45bc-b28e-3609b04e60ad" align="center" width="300px"/> | <img src="https://github.com/winter-love-dev/CatchBottle/assets/26156815/c17a8792-c258-4f51-a9cf-f121c7c23cec" align="center" width="300px"/> |

</div>

---
</br>


## Tech Stack

<p align="left">
  <a href="https://kotlinlang.org"><img alt="Kotlin Version" src="https://img.shields.io/badge/Kotlin-1.8.0-blueviolet.svg?style=flat"/></a>
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
</p>

- <b>AAC-ViewModel</b> Combined with the screen, it maintains screen state and handles UI state and screen rotation events.
- <b>Coroutine</b> Asynchronous Task. Used 'Flow' to make data flow and reflect it in the UI. 
- Jetpack
  - <b>Hilt</b> Dependency Injection
  - <b>Room</b>
    - Focused on implementing functionality by leveraging SQLite wrapped in an abstraction layer, and combined 'Flow' to implement UI interaction more easily.
  - <b>Worker</b>
    - Easy background Asynchronous Task. This included one-time data patching or ongoing data processing.
  - <b>Compose</b>
    - UI work made easier than 'Views' in a declarative manner. Programming by referring to the [Unidirectional data flow document](https://developer.android.com/jetpack/compose/architecture#udf).
    - Programming in ‘Custom UI Component’ units, based on my own 'Design System'.
    - ‘Custom UI component’ that emits events based on higher-order functions
    - Implement a UI testable screen by separating @Composable functions

  - <b>Navigation</b> is Navigate multiple screens with tab navigation
- <b>Glide</b> Image loading library
- <b>Firebase</b>
  - Use <b>RemoteConfig</b>, Implementing Banner Image Event
  - Banckend Storage Managning by <b>FireStorage</b> 
  
All library info : [libs.versions.toml](gradle/libs.versions.toml)

---
</br>

# Architecture

## Compose UI Programming, Reference by [Unidirectional data flow document Pattern](https://developer.android.com/jetpack/compose/architecture#udf).

<!-- ![state-unidirectional-flow](https://github.com/winter-love-dev/ComposeNoteApp/assets/26156815/9c96df0f-14db-4c53-a5ff-0d7337259dae) -->

I have already completed the ['DevFest 2021 Android Jetpack Compose'](https://github.com/winter-love-dev/ComposeFest2021) training course. Also, because I have experience developing declarative UI with iOS and Flutter, I was able to remember and learn this Compose study quickly and easily.

</br>

## Domain Layer, Reference by [Domain Layer Docs](https://developer.android.com/topic/architecture/domain-layer)

Work Focused
- Define feature specification
- Programming on the repository layer or feature layer, By domain layer specification.
- Programming in ‘UseCase’ units
- And code abstraction
<!-- ![mad-arch-domain-overview](https://github.com/winter-love-dev/CatchBottle/assets/26156815/5997a25a-3d89-4314-8bb8-d7f5253c6faf) -->

</br>

## Multi Module Architecture, Reference by [android/nowinandroid](https://github.com/android/nowinandroid)
<!-- ![dep_graph_app](https://github.com/winter-love-dev/CatchBottle/assets/26156815/22cdd95a-29ee-4ea6-be8e-fe42ffeae5a2) -->

</br>

## MVVM Design pattern with Dependency Injection, Reference by [App Arhitecture Guide](https://developer.android.com/topic/architecture)
  
|   |   |
| :---------------: | :---------------: |
| <img src="https://github.com/winter-love-dev/CatchBottle/assets/26156815/f61d9746-f375-4cfa-80ea-20a3cb0ceafb" align="center" width="550px"/> | <img src="https://github.com/winter-love-dev/ComposeNoteApp/assets/26156815/b9c996b3-be27-438e-a952-289990574a5c" align="center" width="350px"/> |

</br>

---
</br>



# License
```
Copyright 2023 winter-love-dev

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
