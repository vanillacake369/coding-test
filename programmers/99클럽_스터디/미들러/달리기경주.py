def solution(players, callings):
    playersDict = dict()
    for idx, player in enumerate(players):
        playersDict[player] = idx
    for calling in callings:
        idx = playersDict[calling]
        players[idx], players[idx - 1] = players[idx - 1], players[idx]
        playersDict[players[idx]] = idx
        playersDict[players[idx - 1]] = idx - 1
    return players


print(
    solution(players=["mumu", "soe", "poe", "kai", "mine"],
             callings=["kai", "kai", "mine", "mine"])
)
