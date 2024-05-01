"""
skill dict
skill 에 맞는 skill tree dict 만들고

skill dict 를 values 기준으로 오름차순 정렬
skill tree dict 를 values 기준으로 오름차순 정렬

skill dict 의 values() 와 skill tree dict 의 values() 의 순서가 맞는지 확인
"""


def isValidSkillTree(eachSkill, skillDict):
    skillTreeDict = dict()
    count = 0
    for skill in eachSkill:
        if skill in skillDict:
            skillTreeDict[skill] = count
            count += 1
    isValid = True
    for skill in skillTreeDict:
        if skillDict[skill] != skillTreeDict[skill]:
            isValid = False
    return isValid


def solution(skill, skill_trees):
    answer = 0
    # answer = -1
    skillDict = dict()
    for idx, eachSkill in enumerate(skill):
        skillDict[eachSkill] = idx
    for eachSkill in skill_trees:
        if isValidSkillTree(eachSkill, skillDict):
            answer += 1
    return answer


skill = "CBD"
skill_trees = ["BACDE", "CBADF", "AECB", "BDA"]
print(solution(skill, skill_trees))
