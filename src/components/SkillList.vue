<template>
  <div class="skills-list">
    <h2>Skills</h2>
    <div v-if="skills.length > 0">
      <ul>
        <li v-for="skill in skills" :key="skill.id">
          <div>
            <strong>{{ skill.skillName }}</strong> 
            <span>Skill Level: {{ skill.proficiencyLevel }}</span>
          </div>
        </li>
      </ul>
    </div>
    <div v-else class="no-skills">
      <p>No skills to display.</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'SkillsList',

  props: {
    skills: {
      type: Array,
      required: true,
    },
  },
};
</script>

<style scoped>
.skills-list {
  padding: 20px;
  border-radius: 8px;
}

.skills-list h2 {
  color: var(--heading-color);
}

.no-skills {
  color: #999;
  font-style: italic;
}

li {
  margin: 10px 0;
  color: var(--text-color);
}

strong {
  font-weight: bold;
}

span {
  margin-left: 10px;
  font-style: italic;
  color: var(--text-color);
}
</style>
