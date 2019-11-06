# CommunicationMod
Slay the Spire mod that provides a protocol for allowing another process to control the game

## Requirements

- Slay the Spire
- ModTheSpire (https://github.com/kiooeht/ModTheSpire)
- BaseMod (https://github.com/daviscook477/BaseMod)

## Setup

1. Copy CommunicationMod.jar to your ModTheSpire mods directory
2. Run ModTheSpire with CommunicationMod enabled
3. Edit your newly-created SpireConfig file with the command you want to use with CommunicationMod (see https://github.com/kiooeht/ModTheSpire/wiki/SpireConfig for the location of your config file). Your config file should look something like this (note that certain special characters must be escaped):
```
#Sat Apr 20 02:49:10 CDT 2019
command=python C\:\\Path\\To\\Script\\main.py
```

## What does this mod do?

CommunicationMod launches a specified process and communicates with this process through stdin and stdout, with the following protocol:

(Note: all messages are assumed to be ended by a new line '\n')

- After starting the external process, CommunicationMod waits for the process to send "ready" on stdout. If "ready" is not received before a specified timeout, the external process will be terminated.
- Whenever the state of the game is determined to be stable (no longer changing without external input), CommunicationMod sends a message containing the JSON representation of the current game state to the external process's stdin. For example:
```
{"available_commands":["play","end","potion","state"],"ready_for_command":true,"in_game":true,"game_state":{"screen_type":"NONE","screen_state":{},"seed":-4614939537923015537,"combat_state":{"draw_pile":[],"discard_pile":[{"exhausts":false,"is_playable":true,"cost":0,"name":"Charge Battery","id":"Conserve Battery","type":"SKILL","uuid":"55151294-2283-4911-8b43-fe941ce83120","upgrades":0,"rarity":"COMMON","has_target":false},{"exhausts":false,"is_playable":true,"cost":1,"name":"Compile Driver","id":"Compile Driver","type":"ATTACK","uuid":"f53d66f7-7cf9-4109-83de-d53b456d21e1","upgrades":0,"rarity":"COMMON","has_target":true},{"exhausts":false,"is_playable":false,"cost":3,"name":"Strike","id":"Strike_B","type":"ATTACK","uuid":"1580bda6-0019-44aa-a7e4-32bd0ee8a45e","upgrades":0,"rarity":"BASIC","has_target":true},{"exhausts":false,"is_playable":true,"cost":1,"name":"Glacier","id":"Glacier","type":"SKILL","uuid":"5b0ff439-f3ea-4e29-a8d6-220f40e17c79","upgrades":0,"rarity":"UNCOMMON","has_target":false},{"exhausts":false,"is_playable":false,"cost":2,"name":"Steam Barrier+","id":"Steam","type":"SKILL","uuid":"c908b641-21b7-4639-8d50-8cb452a166a2","upgrades":1,"rarity":"COMMON","has_target":false},{"exhausts":false,"is_playable":false,"cost":2,"name":"Defend","id":"Defend_B","type":"SKILL","uuid":"e5aba5f6-b6c9-4b8a-b1e4-ae1725fef693","upgrades":0,"rarity":"BASIC","has_target":false},{"exhausts":false,"is_playable":true,"cost":1,"name":"Zap","id":"Zap","type":"SKILL","uuid":"7968ae5c-5f66-4e89-aea5-8b12d680deac","upgrades":0,"rarity":"BASIC","has_target":false},{"exhausts":false,"is_playable":true,"cost":0,"name":"Steam Barrier","id":"Steam","type":"SKILL","uuid":"acb24ea5-7882-46b3-aed0-b0d4d1be10dc","upgrades":0,"rarity":"COMMON","has_target":false},{"exhausts":false,"is_playable":false,"cost":3,"name":"Ball Lightning+","id":"Ball Lightning","type":"ATTACK","uuid":"b366f435-0ccd-44bc-9ba3-b59ae4c8c0c2","upgrades":1,"rarity":"COMMON","has_target":true},{"exhausts":false,"is_playable":false,"cost":2,"name":"Charge Battery","id":"Conserve Battery","type":"SKILL","uuid":"6ebb9913-dc69-4a40-893b-7292dcdc04c1","upgrades":0,"rarity":"COMMON","has_target":false},{"exhausts":true,"is_playable":false,"cost":2,"name":"Rainbow","id":"Rainbow","type":"SKILL","uuid":"a3dabf7d-f5d8-412a-9584-9787c9523ce9","upgrades":0,"rarity":"RARE","has_target":false},{"exhausts":false,"is_playable":false,"cost":2,"name":"Compile Driver+","id":"Compile Driver","type":"ATTACK","uuid":"6735b879-c928-45b0-bddf-e888435ba93f","upgrades":1,"rarity":"COMMON","has_target":true},{"exhausts":false,"is_playable":true,"cost":0,"name":"Defend+","id":"Defend_B","type":"SKILL","uuid":"57514395-6ea8-4e22-a4e0-849a29ec6a35","upgrades":1,"rarity":"BASIC","has_target":false},{"exhausts":false,"is_playable":true,"cost":1,"name":"Dualcast","id":"Dualcast","type":"SKILL","uuid":"7b42f067-dc75-4caf-a05f-0a3b23ccd3f8","upgrades":0,"rarity":"BASIC","has_target":false},{"exhausts":false,"is_playable":true,"cost":0,"name":"Strike","id":"Strike_B","type":"ATTACK","uuid":"626aa55a-555b-485a-bee7-c61ff8508f62","upgrades":0,"rarity":"BASIC","has_target":true},{"exhausts":false,"is_playable":true,"cost":1,"name":"Defend","id":"Defend_B","type":"SKILL","uuid":"6d4a0ea4-4357-4535-b58f-c4df8bc374ff","upgrades":0,"rarity":"BASIC","has_target":false},{"exhausts":false,"is_playable":false,"cost":2,"name":"Loop+","id":"Loop","type":"POWER","uuid":"f95c42f9-f993-4efb-850f-36785403a02c","upgrades":1,"rarity":"UNCOMMON","has_target":false},{"exhausts":false,"is_playable":false,"cost":2,"name":"Charge Battery","id":"Conserve Battery","type":"SKILL","uuid":"3039f0ab-1607-48b7-aed6-83c6c130a19b","upgrades":0,"rarity":"COMMON","has_target":false}],"exhaust_pile":[{"exhausts":true,"is_playable":true,"cost":1,"name":"Chill","id":"Chill","type":"SKILL","uuid":"c3959547-7a3a-4103-983f-715a686746c9","upgrades":0,"rarity":"UNCOMMON","has_target":false}],"cards_discarded_this_turn":0,"monsters":[{"is_gone":false,"move_hits":1,"move_base_damage":16,"last_move_id":3,"half_dead":false,"move_adjusted_damage":16,"max_hp":170,"intent":"ATTACK","second_last_move_id":1,"move_id":1,"name":"Spire Growth","current_hp":56,"block":0,"id":"Serpent","powers":[]}],"turn":4,"limbo":[],"hand":[{"exhausts":false,"is_playable":true,"cost":1,"name":"Defend","id":"Defend_B","type":"SKILL","uuid":"4a22ecef-22a8-4fd4-b7be-d2979d2227a4","upgrades":0,"rarity":"BASIC","has_target":false},{"exhausts":false,"is_playable":false,"cost":3,"name":"Loop","id":"Loop","type":"POWER","uuid":"65bd347b-ed6d-43c0-a022-9e9af3ff7d8d","upgrades":0,"rarity":"UNCOMMON","has_target":false},{"exhausts":false,"is_playable":false,"cost":3,"name":"Cold Snap+","id":"Cold Snap","type":"ATTACK","uuid":"f17e2c71-9863-4945-b66a-11dd312a8ae3","upgrades":1,"rarity":"COMMON","has_target":true},{"exhausts":true,"is_playable":true,"cost":1,"name":"Master of Strategy","id":"Master of Strategy","type":"SKILL","uuid":"55f32fa3-4c2d-46d9-95b1-b09971fc243a","upgrades":0,"rarity":"RARE","has_target":false},{"exhausts":false,"is_playable":true,"cost":1,"name":"Creative AI","id":"Creative AI","type":"POWER","uuid":"2faf0732-047f-4db1-bf58-3237b6f25501","upgrades":0,"rarity":"RARE","has_target":false},{"exhausts":false,"is_playable":true,"cost":1,"name":"Coolheaded","id":"Coolheaded","type":"SKILL","uuid":"0b6d95be-41be-481c-aba5-87c694ffa21a","upgrades":0,"rarity":"COMMON","has_target":false}],"player":{"orbs":[{"passive_amount":5,"name":"Lightning","id":"Lightning","evoke_amount":10},{"passive_amount":4,"name":"Frost","id":"Frost","evoke_amount":7},{"passive_amount":5,"name":"Lightning","id":"Lightning","evoke_amount":10},{"passive_amount":5,"name":"Lightning","id":"Lightning","evoke_amount":10},{"passive_amount":5,"name":"Lightning","id":"Lightning","evoke_amount":10},{"passive_amount":0,"name":"Orb Slot","evoke_amount":0}],"current_hp":16,"block":4,"max_hp":80,"powers":[{"amount":-1,"name":"Confusion","id":"Confusion"},{"amount":1,"name":"Strength","id":"Strength"},{"amount":2,"name":"Focus","id":"Focus"},{"amount":-1,"name":"Electro","id":"Electro"},{"amount":1,"name":"Loop","id":"Loop"},{"amount":10,"name":"Constricted","id":"Constricted"}],"energy":1}},"deck":[{"exhausts":false,"is_playable":true,"cost":1,"name":"Strike","id":"Strike_B","type":"ATTACK","uuid":"626aa55a-555b-485a-bee7-c61ff8508f62","upgrades":0,"rarity":"BASIC","has_target":true},{"exhausts":false,"is_playable":true,"cost":1,"name":"Strike","id":"Strike_B","type":"ATTACK","uuid":"1580bda6-0019-44aa-a7e4-32bd0ee8a45e","upgrades":0,"rarity":"BASIC","has_target":true},{"exhausts":false,"is_playable":true,"cost":1,"name":"Defend","id":"Defend_B","type":"SKILL","uuid":"e5aba5f6-b6c9-4b8a-b1e4-ae1725fef693","upgrades":0,"rarity":"BASIC","has_target":false},{"exhausts":false,"is_playable":true,"cost":1,"name":"Defend+","id":"Defend_B","type":"SKILL","uuid":"57514395-6ea8-4e22-a4e0-849a29ec6a35","upgrades":1,"rarity":"BASIC","has_target":false},{"exhausts":false,"is_playable":true,"cost":1,"name":"Defend","id":"Defend_B","type":"SKILL","uuid":"4a22ecef-22a8-4fd4-b7be-d2979d2227a4","upgrades":0,"rarity":"BASIC","has_target":false},{"exhausts":false,"is_playable":true,"cost":1,"name":"Defend","id":"Defend_B","type":"SKILL","uuid":"6d4a0ea4-4357-4535-b58f-c4df8bc374ff","upgrades":0,"rarity":"BASIC","has_target":false},{"exhausts":false,"is_playable":true,"cost":1,"name":"Zap","id":"Zap","type":"SKILL","uuid":"7968ae5c-5f66-4e89-aea5-8b12d680deac","upgrades":0,"rarity":"BASIC","has_target":false},{"exhausts":false,"is_playable":true,"cost":1,"name":"Dualcast","id":"Dualcast","type":"SKILL","uuid":"7b42f067-dc75-4caf-a05f-0a3b23ccd3f8","upgrades":0,"rarity":"BASIC","has_target":false},{"exhausts":false,"is_playable":true,"cost":1,"name":"Charge Battery","id":"Conserve Battery","type":"SKILL","uuid":"55151294-2283-4911-8b43-fe941ce83120","upgrades":0,"rarity":"COMMON","has_target":false},{"exhausts":false,"is_playable":true,"cost":0,"name":"Steam Barrier","id":"Steam","type":"SKILL","uuid":"acb24ea5-7882-46b3-aed0-b0d4d1be10dc","upgrades":0,"rarity":"COMMON","has_target":false},{"exhausts":false,"is_playable":true,"cost":0,"name":"Steam Barrier+","id":"Steam","type":"SKILL","uuid":"c908b641-21b7-4639-8d50-8cb452a166a2","upgrades":1,"rarity":"COMMON","has_target":false},{"exhausts":false,"is_playable":true,"cost":1,"name":"Ball Lightning+","id":"Ball Lightning","type":"ATTACK","uuid":"b366f435-0ccd-44bc-9ba3-b59ae4c8c0c2","upgrades":1,"rarity":"COMMON","has_target":true},{"exhausts":false,"is_playable":true,"cost":1,"name":"Defragment+","id":"Defragment","type":"POWER","uuid":"32d23c30-1a9c-4ba2-aab4-717a22baebad","upgrades":1,"rarity":"UNCOMMON","has_target":false},{"exhausts":true,"is_playable":true,"cost":0,"name":"Chill","id":"Chill","type":"SKILL","uuid":"c3959547-7a3a-4103-983f-715a686746c9","upgrades":0,"rarity":"UNCOMMON","has_target":false},{"exhausts":false,"is_playable":true,"cost":1,"name":"Charge Battery","id":"Conserve Battery","type":"SKILL","uuid":"3039f0ab-1607-48b7-aed6-83c6c130a19b","upgrades":0,"rarity":"COMMON","has_target":false},{"exhausts":false,"is_playable":true,"cost":1,"name":"Compile Driver+","id":"Compile Driver","type":"ATTACK","uuid":"6735b879-c928-45b0-bddf-e888435ba93f","upgrades":1,"rarity":"COMMON","has_target":true},{"exhausts":false,"is_playable":true,"cost":1,"name":"Charge Battery","id":"Conserve Battery","type":"SKILL","uuid":"6ebb9913-dc69-4a40-893b-7292dcdc04c1","upgrades":0,"rarity":"COMMON","has_target":false},{"exhausts":false,"is_playable":false,"cost":2,"name":"Electrodynamics+","id":"Electrodynamics","type":"POWER","uuid":"c5664e24-3a91-465c-a591-9b7c06a0bcc6","upgrades":1,"rarity":"RARE","has_target":false},{"exhausts":false,"is_playable":false,"cost":3,"name":"Creative AI","id":"Creative AI","type":"POWER","uuid":"2faf0732-047f-4db1-bf58-3237b6f25501","upgrades":0,"rarity":"RARE","has_target":false},{"exhausts":false,"is_playable":true,"cost":1,"name":"Capacitor+","id":"Capacitor","type":"POWER","uuid":"eec8246b-b638-445a-a46b-229df95ed383","upgrades":1,"rarity":"UNCOMMON","has_target":false},{"exhausts":false,"is_playable":true,"cost":1,"name":"Coolheaded","id":"Coolheaded","type":"SKILL","uuid":"0b6d95be-41be-481c-aba5-87c694ffa21a","upgrades":0,"rarity":"COMMON","has_target":false},{"exhausts":true,"is_playable":true,"cost":0,"name":"Master of Strategy","id":"Master of Strategy","type":"SKILL","uuid":"55f32fa3-4c2d-46d9-95b1-b09971fc243a","upgrades":0,"rarity":"RARE","has_target":false},{"exhausts":false,"is_playable":true,"cost":1,"name":"Cold Snap+","id":"Cold Snap","type":"ATTACK","uuid":"f17e2c71-9863-4945-b66a-11dd312a8ae3","upgrades":1,"rarity":"COMMON","has_target":true},{"exhausts":false,"is_playable":true,"cost":1,"name":"Loop","id":"Loop","type":"POWER","uuid":"03a2e300-f14b-44b0-80a5-620864efe24d","upgrades":0,"rarity":"UNCOMMON","has_target":false},{"exhausts":false,"is_playable":true,"cost":1,"name":"Compile Driver","id":"Compile Driver","type":"ATTACK","uuid":"f53d66f7-7cf9-4109-83de-d53b456d21e1","upgrades":0,"rarity":"COMMON","has_target":true},{"exhausts":true,"is_playable":false,"cost":2,"name":"Rainbow","id":"Rainbow","type":"SKILL","uuid":"a3dabf7d-f5d8-412a-9584-9787c9523ce9","upgrades":0,"rarity":"RARE","has_target":false},{"exhausts":false,"is_playable":false,"cost":2,"name":"Glacier","id":"Glacier","type":"SKILL","uuid":"5b0ff439-f3ea-4e29-a8d6-220f40e17c79","upgrades":0,"rarity":"UNCOMMON","has_target":false},{"exhausts":false,"is_playable":true,"cost":1,"name":"Loop","id":"Loop","type":"POWER","uuid":"65bd347b-ed6d-43c0-a022-9e9af3ff7d8d","upgrades":0,"rarity":"UNCOMMON","has_target":false},{"exhausts":false,"is_playable":true,"cost":1,"name":"Loop+","id":"Loop","type":"POWER","uuid":"f95c42f9-f993-4efb-850f-36785403a02c","upgrades":1,"rarity":"UNCOMMON","has_target":false}],"relics":[{"name":"Cracked Core","id":"Cracked Core","counter":-1},{"name":"Letter Opener","id":"Letter Opener","counter":0},{"name":"Maw Bank","id":"MawBank","counter":-2},{"name":"Emotion Chip","id":"Emotion Chip","counter":-1},{"name":"Tiny Chest","id":"Tiny Chest","counter":-1},{"name":"Sozu","id":"Sozu","counter":-1},{"name":"Vajra","id":"Vajra","counter":-1},{"name":"War Paint","id":"War Paint","counter":-1},{"name":"Whetstone","id":"Whetstone","counter":-1},{"name":"Red Mask","id":"Red Mask","counter":-1},{"name":"Snecko Eye","id":"Snecko Eye","counter":-1}],"max_hp":80,"act_boss":"Time Eater","gold":49,"action_phase":"WAITING_ON_USER","act":3,"screen_name":"NONE","room_phase":"COMBAT","is_screen_up":false,"potions":[{"requires_target":true,"can_use":true,"can_discard":true,"name":"Smoke Bomb","id":"SmokeBomb"},{"requires_target":false,"can_use":false,"can_discard":false,"name":"Potion Slot","id":"Potion Slot"},{"requires_target":false,"can_use":false,"can_discard":false,"name":"Potion Slot","id":"Potion Slot"}],"current_hp":16,"floor":39,"ascension_level":0,"class":"DEFECT","map":[{"symbol":"M","children":[{"x":0,"y":1}],"x":0,"y":0,"parents":[]},{"symbol":"M","children":[{"x":3,"y":1}],"x":3,"y":0,"parents":[]},{"symbol":"M","children":[{"x":4,"y":1}],"x":5,"y":0,"parents":[]},{"symbol":"M","children":[{"x":5,"y":1}],"x":6,"y":0,"parents":[]},{"symbol":"M","children":[{"x":0,"y":2}],"x":0,"y":1,"parents":[]},{"symbol":"$","children":[{"x":2,"y":2},{"x":3,"y":2},{"x":4,"y":2}],"x":3,"y":1,"parents":[]},{"symbol":"M","children":[{"x":4,"y":2}],"x":4,"y":1,"parents":[]},{"symbol":"M","children":[{"x":4,"y":2}],"x":5,"y":1,"parents":[]},{"symbol":"?","children":[{"x":1,"y":3}],"x":0,"y":2,"parents":[]},{"symbol":"M","children":[{"x":1,"y":3}],"x":2,"y":2,"parents":[]},{"symbol":"?","children":[{"x":2,"y":3}],"x":3,"y":2,"parents":[]},{"symbol":"M","children":[{"x":5,"y":3}],"x":4,"y":2,"parents":[]},{"symbol":"M","children":[{"x":1,"y":4}],"x":1,"y":3,"parents":[]},{"symbol":"M","children":[{"x":3,"y":4}],"x":2,"y":3,"parents":[]},{"symbol":"M","children":[{"x":5,"y":4},{"x":6,"y":4}],"x":5,"y":3,"parents":[]},{"symbol":"M","children":[{"x":0,"y":5},{"x":2,"y":5}],"x":1,"y":4,"parents":[]},{"symbol":"M","children":[{"x":3,"y":5}],"x":3,"y":4,"parents":[]},{"symbol":"M","children":[{"x":4,"y":5}],"x":5,"y":4,"parents":[]},{"symbol":"?","children":[{"x":5,"y":5}],"x":6,"y":4,"parents":[]},{"symbol":"R","children":[{"x":1,"y":6}],"x":0,"y":5,"parents":[]},{"symbol":"E","children":[{"x":3,"y":6}],"x":2,"y":5,"parents":[]},{"symbol":"R","children":[{"x":4,"y":6}],"x":3,"y":5,"parents":[]},{"symbol":"E","children":[{"x":4,"y":6},{"x":5,"y":6}],"x":4,"y":5,"parents":[]},{"symbol":"M","children":[{"x":6,"y":6}],"x":5,"y":5,"parents":[]},{"symbol":"M","children":[{"x":0,"y":7}],"x":1,"y":6,"parents":[]},{"symbol":"R","children":[{"x":2,"y":7}],"x":3,"y":6,"parents":[]},{"symbol":"M","children":[{"x":3,"y":7}],"x":4,"y":6,"parents":[]},{"symbol":"?","children":[{"x":4,"y":7}],"x":5,"y":6,"parents":[]},{"symbol":"?","children":[{"x":5,"y":7}],"x":6,"y":6,"parents":[]},{"symbol":"R","children":[{"x":0,"y":8}],"x":0,"y":7,"parents":[]},{"symbol":"?","children":[{"x":2,"y":8}],"x":2,"y":7,"parents":[]},{"symbol":"E","children":[{"x":3,"y":8}],"x":3,"y":7,"parents":[]},{"symbol":"?","children":[{"x":5,"y":8}],"x":4,"y":7,"parents":[]},{"symbol":"M","children":[{"x":6,"y":8}],"x":5,"y":7,"parents":[]},{"symbol":"T","children":[{"x":1,"y":9}],"x":0,"y":8,"parents":[]},{"symbol":"T","children":[{"x":3,"y":9}],"x":2,"y":8,"parents":[]},{"symbol":"T","children":[{"x":3,"y":9},{"x":4,"y":9}],"x":3,"y":8,"parents":[]},{"symbol":"T","children":[{"x":4,"y":9}],"x":5,"y":8,"parents":[]},{"symbol":"T","children":[{"x":5,"y":9}],"x":6,"y":8,"parents":[]},{"symbol":"M","children":[{"x":0,"y":10}],"x":1,"y":9,"parents":[]},{"symbol":"E","children":[{"x":3,"y":10},{"x":4,"y":10}],"x":3,"y":9,"parents":[]},{"symbol":"R","children":[{"x":4,"y":10}],"x":4,"y":9,"parents":[]},{"symbol":"?","children":[{"x":4,"y":10}],"x":5,"y":9,"parents":[]},{"symbol":"M","children":[{"x":1,"y":11}],"x":0,"y":10,"parents":[]},{"symbol":"M","children":[{"x":4,"y":11}],"x":3,"y":10,"parents":[]},{"symbol":"?","children":[{"x":4,"y":11},{"x":5,"y":11}],"x":4,"y":10,"parents":[]},{"symbol":"?","children":[{"x":2,"y":12}],"x":1,"y":11,"parents":[]},{"symbol":"?","children":[{"x":4,"y":12},{"x":5,"y":12}],"x":4,"y":11,"parents":[]},{"symbol":"M","children":[{"x":6,"y":12}],"x":5,"y":11,"parents":[]},{"symbol":"M","children":[{"x":2,"y":13}],"x":2,"y":12,"parents":[]},{"symbol":"$","children":[{"x":5,"y":13}],"x":4,"y":12,"parents":[]},{"symbol":"R","children":[{"x":6,"y":13}],"x":5,"y":12,"parents":[]},{"symbol":"M","children":[{"x":6,"y":13}],"x":6,"y":12,"parents":[]},{"symbol":"M","children":[{"x":2,"y":14}],"x":2,"y":13,"parents":[]},{"symbol":"?","children":[{"x":5,"y":14}],"x":5,"y":13,"parents":[]},{"symbol":"$","children":[{"x":5,"y":14},{"x":6,"y":14}],"x":6,"y":13,"parents":[]},{"symbol":"R","children":[{"x":3,"y":16}],"x":2,"y":14,"parents":[]},{"symbol":"R","children":[{"x":3,"y":16}],"x":5,"y":14,"parents":[]},{"symbol":"R","children":[{"x":3,"y":16}],"x":6,"y":14,"parents":[]}],"room_type":"MonsterRoom"}}
```
- CommunicationMod then waits for a message back from the external process, containing a command to be executed. Possible commands are:
  - START PlayerClass [AscensionLevel] [Seed]
    - Starts a new game with the selected class, on the selected Ascension level (default 0), with the selected seed (random seed if omitted).
    - Seeds are alphanumeric, as displayed in game.
    - This and all commands are case insensitive.
    - Only currently available in the main menu of the game.
  - POTION Use|Discard PotionSlot [TargetIndex]
    - Uses or discards the potion in the selected slot, on the selected target, if necessary.
    - TargetIndex is the index of the target monster in the game's monster array (0-indexed).
    - Only available when potions can be used or discarded.
  - PLAY CardIndex [TargetIndex]
    - Plays the selected card in your hand, with the selected target, if necessary.
    - Only available when cards can be played in combat.
    - Currently, CardIndex is 1-indexed to match up with the card numbers in game.
  - END
    - Ends your turn.
    - Only available when the end turn button is available, in combat.
  - CHOOSE ChoiceIndex|ChoiceName
    - Makes a choice relevant to the current screen.
    - A list of names for each choice is provided in the game state. If provided with a name, the first choice index with the matching name is selected.
    - Generally, available at any point when PLAY is not available.
  - PROCEED
    - Clicks the button on the right side of the screen, generally causing the game to proceed to a new screen.
    - Equivalent to CONFIRM.
    - Available whenever the proceed or confirm button is present on the right side of the screen.
  - RETURN
    - Clicks the button on the left side of the screen, generally causing you to return to the previous screen.
    - Equivalent to SKIP, CANCEL, and LEAVE.
    - Available whenever the return, cancel, or leave buttons are present on the left side of the screen. Also used for the skip button on card reward screens.
  - STATE
    - Causes CommunicationMod to immediately send a JSON representation of the current state to the external process, whether or not the game state is stable.
    - Always available.
- Upon receiving a command, CommunicationMod will execute it, and reply again with a JSON representation of the state of the game, when it is next stable.
- If there was an error in executing the command, CommunicationMod will instead send an error message of the form:
```
{"error":"Error message","ready_for_command":True}
```

## Known issues and limitations, to be hopefully fixed soon:
- The full state of the Match and Keep event is not transmitted.
- There is no feedback or state change if you attempt to take or buy a potion while your potion inventory is full. Beware!
- Unselecting cards in hand select screens is not supported.
- Several actions do not currently register a state change if they are performed manually in game.
- You must manually edit the mod's config file to set the command for your external process.
- Communication Mod has only been tested on Windows 10 at this point.
- Communication Mod has not been tested without fast mode on.
- Some of the commands will currently hijack your mouse cursor, though the hijacking of your mouse will go away in future versions.

## What are some of the potential applications of this mod?

- Twitch plays Slay the Spire
- Slay the Spire AIs
- Streamers can display detailed information about the current run while in game
