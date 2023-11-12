import { v4 as uuidv4 } from 'uuid';

export const prepareCards = (icons) => {
	const pairedIcons = [...icons, ...icons];

	const shuffledIcons = pairedIcons.sort(() => Math.random() - 0.5).map(icon => ({ ...icon, id: uuidv4() }));

	const result = [];

	for (let i = 0; i < shuffledIcons.length; i += 4) {
		result.push(shuffledIcons.slice(i, i + 4));
	};

	return result;
};