# MegaAutoBuyer (scaffold)

This repository now contains a **Fabric 1.21.4 scaffold** for MegaAutoBuyer with:

- Mod bootstrap (`ModInitializer` + `ClientModInitializer`)
- Keybind (`O`) and `/autobuyer gui` client command
- Simple GUI screen placeholder
- JSON config + stats persistence using Gson
- Price parser utility with multilingual regex defaults
- Async Discord webhook sender stub
- Language files (`en_us`, `pl_pl`, `de_de`, `fr_fr`, `es_es`, `zh_cn`)

## Build

```bash
./gradlew build
```

## Current status

This is an initial foundation, not the full 150-200 file implementation yet.
